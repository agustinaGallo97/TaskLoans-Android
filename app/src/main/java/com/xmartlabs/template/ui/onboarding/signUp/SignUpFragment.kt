package com.xmartlabs.template.ui.onboarding.signUp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.template.R
import kotlinx.android.synthetic.main.fragment_signup.*
import javax.inject.Inject

@FragmentWithArgs
class SignUpFragment : BaseFragment() {
  companion object {
    private const val PASSWORD_LENGHT = 8
  }

  override val layoutResId: Int
    get() = R.layout.fragment_signup

  @Inject
  lateinit var signUpViewModel: SignUpViewModel

  private lateinit var signUpButton: Button

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    signUpButton = view.findViewById(R.id.createAccount)
  }

  override fun onStart() {
    super.onStart()

    signUpButton.setOnClickListener {
      if (isCorrectRequest()) {
        Toast.makeText(context, "Correct sign up with" +
            " name:${user.text}," +
            " mail:${mail.text} and " +
            " pass:${password.text}", Toast.LENGTH_SHORT).show()
        signUpViewModel.signUp(user.text.toString(), mail.text.toString(), password.text.toString())
        Toast.makeText(context, "Signed up correctly", Toast.LENGTH_SHORT).show()
      }
    }
  }

  private fun isCorrectRequest(): Boolean =
      (validate(user.text.isNotEmpty(),
          "Error, name can't be empty") &&
          validate(isCorrectMail(mail.text.toString()),
              "Error, invalid mail")) &&
          validate(isCorrectPassword(password.text.toString()),
              "Error, password can't be empty and must have at least 8 characters")

  private fun validate(condition: Boolean, message: String): Boolean {
    if (!condition) Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    return condition
  }

  private fun isCorrectPassword(password: String): Boolean =
      password.isNotEmpty() && password.length > PASSWORD_LENGHT

  private fun isCorrectMail(mail: String): Boolean =
      mail.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()
}
