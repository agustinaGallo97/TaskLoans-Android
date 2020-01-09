package com.xmartlabs.template.ui.onboarding.signUp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.template.R
import kotlinx.android.synthetic.main.fragment_signup.*
import javax.inject.Inject

@FragmentWithArgs
class SignUpFragment : BaseFragment() {
  companion object {
    private const val MIN_PASSWORD_LENGTH = 8
  }

  override val layoutResId: Int
    get() = R.layout.fragment_signup

  @Inject
  lateinit var signUpViewModel: SignUpViewModel

  private lateinit var signUpButton: Button

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setUpVars(view)
    signUpViewModelObserver()
    buttonsListener()
  }

  private fun setUpVars(view: View) {
    signUpButton = view.findViewById(R.id.createAccount)
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
    Toast.makeText(context, "Error, already exists a user with the same mail", Toast.LENGTH_SHORT).show()
  }

  private fun onSuccessResult() {
    // TODO fix it in the future
    Toast.makeText(context, "Signed up correctly", Toast.LENGTH_SHORT).show()
  }

  private fun buttonsListener() {
    signUpButton.setOnClickListener {
      if (isCorrectRequest()) {
        signUpViewModel.signUp(user.text.toString(), mail.text.toString(), password.text.toString())
      }
    }
  }

  private fun isCorrectRequest(): Boolean =
      (validateAndShowErrorIfNeeded(user.text.isNotEmpty(), "Error, name can't be empty") &&
          validateAndShowErrorIfNeeded(isCorrectMail(mail.text.toString()),
              "Error, invalid mail")) &&
          (validateAndShowErrorIfNeeded(isCorrectPassword(password.text.toString()),
              "Error, password can't be empty and must has at least 8 characters"))

  private fun validateAndShowErrorIfNeeded(condition: Boolean, message: String): Boolean {
    if (!condition) Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    return condition
  }

  private fun isCorrectPassword(password: String): Boolean =
      password.isNotEmpty() && password.length > MIN_PASSWORD_LENGTH

  private fun isCorrectMail(mail: String): Boolean =
      mail.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()
}
