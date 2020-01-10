package com.xmartlabs.template.ui.onboarding.signIn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.template.App
import com.xmartlabs.template.R
import com.xmartlabs.template.helper.OnBoardingValidator
import com.xmartlabs.template.ui.Henson
import kotlinx.android.synthetic.main.fragment_sign_in.*
import javax.inject.Inject

@FragmentWithArgs
class SignInFragment : BaseFragment() {
  override val layoutResId = R.layout.fragment_sign_in

  @Inject
  lateinit var signInViewModel: SignInViewModel

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    signInViewModelObserver()
    buttonsListener()
  }

  private fun signInViewModelObserver() {
    signInViewModel.signIn.observe(this, Observer { result ->
      when {
        result.isSuccess -> onSuccessResult()
        result.isFailure -> onFailureResult()
      }
    })
  }

  private fun onFailureResult() {
    Toast.makeText(context, App.context.resources.getString(R.string.error_incorrect_login), Toast.LENGTH_SHORT)
        .show()
  }

  private fun onSuccessResult() {
    // TODO fix it in the future
    Toast.makeText(context, App.context.resources.getString(R.string.sign_in_correctly), Toast.LENGTH_SHORT)
        .show()
  }

  private fun buttonsListener() {
    loginButtonListener()
    createAccountTextViewListener()
  }

  private fun loginButtonListener() {
    loginButton.setOnClickListener {
      if (isCorrectRequest()) {
        signInViewModel.signIn(mail.text.toString(), password.text.toString())
      } else {
        Toast.makeText(context, resources.getString(
            when {
              !OnBoardingValidator.isCorrectMail(mail.text.toString()) -> R.string.error_invalid_mail
              else -> R.string.error_invalid_password
            }
        ), Toast.LENGTH_SHORT).show()
      }
    }
  }

  private fun createAccountTextViewListener() {
    createAccountTextView.setOnClickListener {
      val intent = Henson.with(context)
          .gotoSignUpActivity()
          .build()
          .setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_CLEAR_TASK)
      startActivity(intent)
    }
  }

  private fun isCorrectRequest(): Boolean =
      OnBoardingValidator.isCorrectMail(mail.text.toString()) &&
          OnBoardingValidator.isCorrectPassword(password.text.toString())
}
