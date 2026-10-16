package com.example.myapplication

import androidx.compose.runtime.*
import android.R.attr.contentDescription
import android.R.attr.shape
import android.R.attr.x
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.nio.file.WatchEvent
val UnboundedFontFamily = FontFamily(
    Font(R.font.unbounded_variable, FontWeight.ExtraBold)
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                var currentScreen by remember { mutableStateOf("splash") }

                LaunchedEffect(key1 = Unit) {
                    kotlinx.coroutines.delay(2000L)
                    currentScreen = "welcome"
                }

                when (currentScreen) {
                    "splash" -> {
                        SplashScreen()
                    }

                    "welcome" -> {
                        LoginScreen(
                            onLoginClick = { currentScreen = "login_details" },
                            onSignUpClick = { currentScreen = "registration" }
                        )
                    }
                    "login_details" -> {
                        LoginDetailsScreen(
                            onBackClick = { currentScreen = "welcome" },
                            onSignUpClick = {currentScreen = "registration" }
                        )
                    }
                    "registration" -> {
                        RegistrationScreen(
                            onBackClick = { currentScreen = "welcome" }
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun SplashScreen(){
    Box(
        modifier = Modifier.fillMaxWidth()
            .background(Color(0xFFFF5A1F)),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.delivery_logo2),
            contentDescription = "Логотип доставки",
            modifier = Modifier
                .padding(start = (96 - 16) .dp)
                .size(width = 253.dp, height = 233.dp)
        )

    }
}
@Composable
fun LoginScreen(onLoginClick: () -> Unit, onSignUpClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFF5A1F))
    ) {

        Image(
            painter = painterResource(id = R.drawable.circle1),
            contentDescription = "Кола",
            modifier = Modifier
                .size(417.dp)
                .align(Alignment.TopEnd)
                .offset(x = 80.dp, y = 150.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(120.dp))
            Text(
                text = "DELIVERY №1",
                fontSize = 14.sp,
                color = Color(0xFF14100D)
            )

            Spacer(modifier = Modifier.height(270.dp))
            val UnboundedFontFamily = null
            Text(
                text = "FAST\nFOOD\nDELIVERY",
                fontSize = 52.sp,
                fontFamily = UnboundedFontFamily,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF14100D),
                lineHeight = 44.sp
            )

            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Hot food from your favorite places —\nat your door in 30 minutes.",
                fontSize = 14.sp,
                color = Color(0xFF14100D),
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(40.dp))


            Button(
                onClick = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF14100D))
            ) {
                Text(text = "Log in", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onSignUpClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFF4E6))
            ) {
                Text(text = "Sign up", color = Color(0xFFFF6F23))
            }
        }
    }
}

@Composable
fun LoginDetailsScreen(onBackClick: () -> Unit, onSignUpClick: () -> Unit) {
    var loginText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF14100D))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.button_witharrow),
                contentDescription = "button",
                modifier = Modifier
                    .size(29.dp)
                    .clickable { onBackClick() }
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = loginText,
            onValueChange = { loginText = it },
            placeholder = { Text("name@gmail.com", color = Color(0xFF747473)) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = passwordText,
            onValueChange = { passwordText = it },
            placeholder = { Text("* * * * * * * * ", color = Color(0xFF747473)) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFFF6A1F),
                        uncheckedColor = Color(0xFFFF6A1F),
                        checkmarkColor = Color(0xFF14100D)
                    )
                )
                Text(text = "Remember me", fontSize = 10.sp, color = Color(0xFFB9A89A))

            }
            TextButton(onClick = { }) {
                Text(text = "Forgot password?", fontSize = 10.sp, color = Color(0xFFFF6A1F))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6A1F))
        ) {
            Text(text = "Log in", color = Color(0xFF14100D), fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Color(0xFFB9A89A),
            )
            Text(
                text = "OR",
                color = Color(0xFFB9A89A),
                fontSize = 13.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Color(0xFFB9A89A),
            )

        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFF4E6)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))

                Text(text = "Log in with Google", color = Color(0xFF14100D), fontSize = 14.sp)

            }

        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFF4E6)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "Apple",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))

                Text(text = "Log in with Apple", color = Color(0xFF14100D), fontSize = 14.sp)

            }

        }
        Spacer(modifier = Modifier.height(28.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account? ",
                color = Color(0xFFB9A89A),
                fontSize = 12.sp
            )
            Text(
                text = "Sign up.",
                color = Color(0xFFFF7A00),
                fontSize = 12.sp,
                modifier = Modifier.clickable {
                    onSignUpClick()

                }
            )

        }
    }
}

        @Composable

        fun RegistrationScreen(onBackClick: () -> Unit) {
            var firstNameText by remember { mutableStateOf("") }
            var lastNameText by remember { mutableStateOf("") }
            var emailText by remember { mutableStateOf("") }
            var phoneNumberText by remember { mutableStateOf("") }
            var passwordText by remember { mutableStateOf("") }
            var confirmPasswordText by remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFDF7))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(60.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.button_witharrow),
                        contentDescription = "button",
                        modifier = Modifier
                            .size(29.dp)
                            .clickable { onBackClick() }
                    )
                    Spacer(modifier = Modifier.width(120.dp))

                    Text(text = "Sign up", color = Color(0xFF2B2560), fontSize = 20.sp)

                }

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = firstNameText,
                    onValueChange = { firstNameText = it },
                    placeholder = {
                        Text(
                            text = "First name",
                            color = Color(0xFFB0B0B0),
                            fontSize = 12.sp
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)


                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = lastNameText,
                    onValueChange = { lastNameText = it},
                    placeholder = {
                        Text(
                            text = "Last name",
                            color = Color(0xFFB0B0B0),
                            fontSize = 12.sp
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = emailText,
                    onValueChange = { emailText = it},
                    placeholder = {
                        Text(
                            text = "E-mail",
                            color = Color(0xFFB0B0B0),
                            fontSize = 12.sp
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = phoneNumberText,
                    onValueChange = { phoneNumberText = it},
                    placeholder = {
                        Text(
                            text = "Phone number",
                            color = Color(0xFFB0B0B0),
                            fontSize = 12.sp
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = passwordText,
                    onValueChange = { passwordText = it},
                    placeholder = {
                        Text(
                            text = "Password",
                            color = Color(0xFFB0B0B0),
                            fontSize = 12.sp
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = confirmPasswordText,
                    onValueChange = { confirmPasswordText = it},
                    placeholder = {
                        Text(
                            text = "Confirm password",
                            color = Color(0xFFB0B0B0),
                            fontSize = 12.sp
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )

                Spacer(modifier = Modifier.height(44.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F23))
                ) {

                    Text(text = "Sign up", color = Color.White, fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(80.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "I confirm acceptance ",
                        color = Color(0xFF2B2560),
                        fontSize = 12.sp
                    )
                    Text(
                        text = "of the Terms of Service ",
                        color = Color(0xFFFF7A00),
                        fontSize = 12.sp,
                        modifier = Modifier.clickable{}
                    )

                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "and ",
                        color = Color(0xFF2B2560),
                        fontSize = 12.sp
                    )
                    Text(
                        text = "Privacy Policy.",
                        color = Color(0xFFFF7A00),
                        fontSize = 12.sp,
                        modifier = Modifier.clickable {}
                    )
                }





            }

        }










