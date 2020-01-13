package com.xmartlabs.template.ui.onboarding.signup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.template.App
import com.xmartlabs.template.R
import kotlinx.android.synthetic.main.fragment_signup.*
import javax.inject.Inject

@FragmentWithArgs
class SignUpFragment : BaseFragment() {
  companion object {
    private const val MIN_PASSWORD_LENGTH = 8
  }

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
        result.isSuccess -> onSignUpSuccess()
        result.isFailure -> onSignUpFailure()
      }
    })
  }

  private fun onSignUpFailure() {
    // TODO fix it in the future
    Toast.makeText(context, App.context.resources.getString(R.string.error_user_already_exists), Toast.LENGTH_SHORT)
        .show()
  }

  private fun onSignUpSuccess() {
    // TODO fix it in the future
    Toast.makeText(context, App.context.resources.getString(R.string.sign_up_correctly), Toast.LENGTH_SHORT)
        .show()
  }

  private fun buttonsListener() {
    createAccountButton.setOnClickListener {
      if (isCorrectRequest()) {
        signUpViewModel.signUp(
            userTextInputEditText.text.toString(),
            mailTextInputEditText.text.toString(),
            passwordTextInputEditText.text.toString()
        )
      } else {
        Toast.makeText(context, resources.getString(
            when {
              !isCorrectName(userTextInputEditText.text.toString()) -> R.string.error_name_empty
              !isCorrectMail(mailTextInputEditText.text.toString()) -> R.string.error_invalid_mail
              !isCorrectPassword(passwordTextInputEditText.text.toString()) -> R.string.error_invalid_password
              else -> R.string.error_check_password
            }
        ), Toast.LENGTH_SHORT).show()
      }
    }
  }

  private fun isCorrectRequest(): Boolean =
      isCorrectName(userTextInputEditText.text.toString()) &&
          isCorrectMail(mailTextInputEditText.text.toString()) &&
          isCorrectPassword(passwordTextInputEditText.text.toString()) &&
              isCorrectCheckPassword(passwordTextInputEditText.text.toString(),
                  checkPasswordTextInputEditText.text.toString())

  private fun isCorrectName(name: String) = name.isNotEmpty()

  private fun isCorrectMail(mail: String): Boolean =
      mail.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()

  private fun isCorrectPassword(password: String): Boolean =
      password.isNotEmpty() && password.length > MIN_PASSWORD_LENGTH

  private fun isCorrectCheckPassword(password: String, checkPassword: String) =
      password.isNotEmpty() && password == checkPassword
}
