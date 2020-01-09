package com.xmartlabs.template.ui.onboarding.signUp

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
        result.isSuccess -> onSuccessResult()
        result.isFailure -> onFailureResult()
      }
    })
  }

  private fun onFailureResult() {
    // TODO fix it in the future
    Toast.makeText(context, App.context.resources.getString(R.string.error_user_already_exists), Toast.LENGTH_SHORT).show()
  }

  private fun onSuccessResult() {
    // TODO fix it in the future
    Toast.makeText(context, App.context.resources.getString(R.string.sign_up_correctly), Toast.LENGTH_SHORT).show()
  }

  private fun buttonsListener() {
    createAccountButton.setOnClickListener {
      if (isCorrectRequest()) {
        signUpViewModel.signUp(user.text.toString(), mail.text.toString(), password.text.toString())
      }
    }
  }

  private fun isCorrectRequest(): Boolean =
      (validateAndShowErrorIfNeeded(user.text!!.isNotEmpty(), App.context.resources.getString(R.string.error_invalid_password)) &&
          validateAndShowErrorIfNeeded(isCorrectMail(mail.text.toString()),
              App.context.resources.getString(R.string.error_invalid_mail))) &&
          (validateAndShowErrorIfNeeded(isCorrectPassword(password.text.toString()),
              App.context.resources.getString(R.string.error_invalid_password)) &&
              validateAndShowErrorIfNeeded(isSamePassword(password.text.toString(), checkPassword.text.toString()),
                  App.context.resources.getString(R.string.error_check_password)))

  private fun validateAndShowErrorIfNeeded(condition: Boolean, message: String): Boolean {
    if (!condition) Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    return condition
  }

  private fun isCorrectPassword(password: String): Boolean =
      password.isNotEmpty() && password.length > MIN_PASSWORD_LENGTH

  private fun isCorrectMail(mail: String): Boolean =
      mail.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()

  private fun isSamePassword(password: String, checkPassword: String) = (password.isNotEmpty() && password == checkPassword)
}
