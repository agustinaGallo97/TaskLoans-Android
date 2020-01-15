package com.xmartlabs.taskloans.ui.onboarding.signin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.taskloans.App
import com.xmartlabs.taskloans.R
import com.xmartlabs.taskloans.helper.Router
import com.xmartlabs.taskloans.helper.isCorrectMail
import com.xmartlabs.taskloans.helper.isCorrectPassword
import kotlinx.android.synthetic.main.fragment_sign_in.*
import javax.inject.Inject

@FragmentWithArgs
class SignInFragment : BaseFragment() {
  @Inject
  lateinit var signInViewModel: SignInViewModel

  override val layoutResId = R.layout.fragment_sign_in

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    signInViewModelObserver()
    setUpListeners()
  }

  private fun signInViewModelObserver() {
    signInViewModel.signIn.observe(this, Observer { result ->
      when {
        result.isSuccess -> onSignInSuccess()
        result.isFailure -> onSignInFailure()
      }
    })
  }

  private fun onSignInFailure() =
      Toast.makeText(context, App.context.resources.getString(R.string.error_incorrect_login), Toast.LENGTH_SHORT)
          .show()

  private fun onSignInSuccess() {
    Router.goToDashboardActivity(this)
  }

  private fun setUpListeners() {
    setUpLoginButtonListener()
    setUpCreateAccountTextViewListener()
  }

  private fun setUpLoginButtonListener() =
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

  private fun setUpCreateAccountTextViewListener() =
      createAccountTextView.setOnClickListener {
        Router.goToSignUpActivity(this)
      }

  private fun isCorrectRequest() =
      isCorrectMail(mailTextInputEditText.text.toString()) &&
          isCorrectPassword(passwordTextInputEditText.text.toString())
}
