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
    private const val PASSWORD_LENGTH = 8
  }

  override val layoutResId: Int
    get() = R.layout.fragment_signup

  @Inject
  lateinit var signUpViewModel: SignUpViewModel

  private lateinit var signUpButton: Button

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    signUpButton = view.findViewById(R.id.createAccount)

    signUpViewModel.signUp.observe(this, Observer { result ->
      when {
        result.isSuccess -> Toast.makeText(context, "Signed up correctly", Toast.LENGTH_SHORT).show()
        result.isFailure -> Toast.makeText(context, "Error, already exists a user with the same mail",
            Toast.LENGTH_SHORT).show()
      }
    })
  }

  override fun onStart() {
    super.onStart()

    signUpButton.setOnClickListener {
      if (isCorrectRequest()) {
        signUpViewModel.signUp(user.text.toString(), mail.text.toString(), password.text.toString())
      }
    }
  }

  private fun isCorrectRequest(): Boolean =
      (validate(user.text.isNotEmpty(), "Error, name can't be empty") &&
          validate(isCorrectMail(mail.text.toString()),
          "Error, invalid mail")) &&
          (validate(isCorrectPassword(password.text.toString()),
          "Error, password can't be empty and must has at least 8 characters"))

  private fun validate(condition: Boolean, message: String): Boolean {
    if (!condition) Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    return condition
  }

  private fun isCorrectPassword(password: String): Boolean =
      password.isNotEmpty() && password.length > PASSWORD_LENGTH

  private fun isCorrectMail(mail: String): Boolean =
      mail.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()
}
