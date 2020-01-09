package com.xmartlabs.template.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xmartlabs.template.usecase.internal.DefaultScheduler
import com.xmartlabs.template.usecase.internal.Scheduler
import io.reactivex.Single
import timber.log.Timber

/*
 This class is created as a template of each necessary useCase.
*/

abstract class BaseSingleUseCase<in P, R> {
  protected var taskScheduler: Scheduler = DefaultScheduler

  /** Executes the use case asynchronously and places the [Result] in a MutableLiveData
   *
   * @param parameters the input parameters to run the use case with
   * @param result the MutableLiveData where the result is posted to
   *
   */
  operator fun invoke(parameters: P, result: MutableLiveData<Result<R>>) {
    // result.value = Result.Loading TODO: add data to Loading to avoid glitches
    try {
      taskScheduler.execute {
        try {
          execute(parameters).let { useCaseSingleResult ->
            result.postValue(Result.success(useCaseSingleResult.blockingGet())) // TODO: Fix it in the future
          }
        } catch (e: InterruptedException) {
          Timber.e(e)
          result.postValue(Result.failure(e))
        }
      }
    } catch (e: InterruptedException) {
      Timber.d(e)
      result.postValue(Result.failure(e))
    }
  }

  /** Executes the use case asynchronously and returns a [Result] in a new LiveData object.
   *
   * @return an observable [LiveData] with a [Result].
   *
   * @param parameters the input parameters to run the use case with
   */
  operator fun invoke(parameters: P): LiveData<Result<R>> {
    val liveCallback: MutableLiveData<Result<R>> = MutableLiveData()
    this(parameters, liveCallback)
    return liveCallback
  }

  /** Executes the use case synchronously  */
  fun executeNow(parameters: P) =
      try {
        Result.success(execute(parameters).blockingGet())
      } catch (e: InterruptedException) {
        Result.failure<R>(e)
      }

  /**
   * Override this to set the code to be executed.
   */
  protected abstract fun execute(parameters: P): Single<R>
}

operator fun <R> BaseSingleUseCase<Unit, R>.invoke(): LiveData<Result<R>> = this(Unit)
operator fun <R> BaseSingleUseCase<Unit, R>.invoke(result: MutableLiveData<Result<R>>) = this(Unit, result)
