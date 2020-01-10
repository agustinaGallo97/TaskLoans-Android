package com.xmartlabs.template.ui.onboarding.signUp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.template.App
import com.xmartlabs.template.R
import com.xmartlabs.template.helper.OnBoardingValidator
import kotlinx.android.synthetic.main.fragment_signup.*
import javax.inject.Inject

@FragmentWithArgs
class SignUpFragment : BaseFragment() {
  override val layoutResId = R.layout.fragment_signup

  @Inject
  lateinit var signUpViewModel: SignUpViewModel

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    signUpViewModelObserver()
    buttonsListener()
  }

  private fun signUpViewModelObserver() {
    signUpViewModel.signUp.observe(this, Observer { result ->
      when {
        result.isSuccess -> onSuccessResult()
        result.isFailure -> onFailureResult()
      }
    })
  }

  private fun onFailureResult() {
    Toast.makeText(context, App.context.resources.getString(R.string.error_user_already_exists), Toast.LENGTH_SHORT)
        .show()
  }

  private fun onSuccessResult() {
    // TODO fix it in the future
    Toast.makeText(context, App.context.resources.getString(R.string.sign_up_correctly), Toast.LENGTH_SHORT)
        .show()
  }

  private fun buttonsListener() {
    createAccountButton.setOnClickListener {
      if (isCorrectRequest()) {
        signUpViewModel.signUp(user.text.toString(), mail.text.toString(), password.text.toString())
      } else {
        Toast.makeText(context, resources.getString(
            when {
              !OnBoardingValidator.isCorrectName(user.text.toString()) -> R.string.error_name_empty
              !OnBoardingValidator.isCorrectMail(mail.text.toString()) -> R.string.error_invalid_mail
              !OnBoardingValidator.isCorrectPassword(password.text.toString()) -> R.string.error_invalid_password
              else -> R.string.error_check_password
            }
        ), Toast.LENGTH_SHORT).show()
      }
    }
  }

  private fun isCorrectRequest(): Boolean =
      (OnBoardingValidator.isCorrectName(user.text.toString()) &&
          OnBoardingValidator.isCorrectMail(mail.text.toString())) &&
          (OnBoardingValidator.isCorrectPassword(password.text.toString()) &&
              OnBoardingValidator.isCorrectCheckPassword(password.text.toString(), checkPassword.text.toString()))
}
