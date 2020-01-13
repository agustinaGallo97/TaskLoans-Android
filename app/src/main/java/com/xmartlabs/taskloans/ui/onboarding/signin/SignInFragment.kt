package com.xmartlabs.taskloans.ui.onboarding.signin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.taskloans.App
import com.xmartlabs.taskloans.R
import com.xmartlabs.taskloans.helper.isCorrectMail
import com.xmartlabs.taskloans.helper.isCorrectPassword
import com.xmartlabs.taskloans.ui.Henson
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
        signInViewModel.signIn(mailTextInputEditText.text.toString(), passwordTextInputEditText.text.toString())
      } else {
        Toast.makeText(context, resources.getString(
            when {
              !isCorrectMail(mailTextInputEditText.text.toString()) -> R.string.error_invalid_mail
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
      isCorrectMail(mailTextInputEditText.text.toString()) &&
          isCorrectPassword(passwordTextInputEditText.text.toString())
}
