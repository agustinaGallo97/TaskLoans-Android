package com.xmartlabs.template.ui.onboarding.signUp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.template.R
import kotlinx.android.synthetic.main.fragment_signup.*

@FragmentWithArgs
class SignUpFragment : BaseFragment() {
  override val layoutResId: Int
    get() = R.layout.fragment_signup

  private lateinit var signUpButton: Button
  private lateinit var signUpViewModel: SignUpViewModel

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    signUpButton = view.findViewById(R.id.createAccount)
  }

  override fun onStart() {
    super.onStart()

    signUpButton.setOnClickListener {
      if (isCorrectRequest()) {
        signUpViewModel.signUp(user.text.toString(), mail.text.toString(), password.text.toString())
      } else
        Toast.makeText(context, "Invalid sign up", Toast.LENGTH_SHORT).show()
    }
  }

  private fun isCorrectRequest(): Boolean =
      ((user.text.isNotEmpty() && isCorrectMail(mail.text.toString())) &&
          isCorrectPassword(password.text.toString()))

  private fun isCorrectPassword(password: String): Boolean = password.isNotEmpty() && password.length > 8

  private fun isCorrectMail(mail: String): Boolean =
      mail.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()
}
