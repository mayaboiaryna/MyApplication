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
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.nio.file.WatchEvent
@OptIn(ExperimentalTextApi::class)
val UnboundedFontFamily = FontFamily(
    Font(R.font.unbounded_extralight, FontWeight.ExtraLight),
    Font(R.font.unbounded_light, FontWeight.Light),
    Font(R.font.unbounded_medium, FontWeight.Medium),
    Font(R.font.unbounded_regular, FontWeight.Normal),
    Font(R.font.unbounded_semibold, FontWeight.SemiBold),
    Font(R.font.unbounded_bold, FontWeight.Bold),
    Font(R.font.unbounded_extrabold, FontWeight.ExtraBold),
    Font(R.font.unbounded_black, FontWeight.Black)
)
val WorkSansFontFamily = FontFamily(
    Font(R.font.worksans_semibold, FontWeight.SemiBold),
    Font(R.font.worksans_medium, FontWeight.Medium),
    Font(R.font.worksans_bold, FontWeight.Bold),
    Font(R.font.worksans_extrabold, FontWeight.ExtraBold)
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
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFF5A1F)),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.delivery_logo2),
            contentDescription = "Логотип доставки",
            modifier = Modifier
                .padding(start = (96 - 16).dp)
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
                color = Color(0xFF14100D),
                fontFamily = UnboundedFontFamily,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.05.em
            )

            Spacer(modifier = Modifier.height(270.dp))
            Text(
                text = "FAST\nFOOD\nDELIVERY",
                fontSize = 50.sp,
                fontFamily = UnboundedFontFamily,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF14100D),
                lineHeight = 44.sp
            )

            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Hot food from your favorite place —\nat your door in 30 minutes.",
                fontSize = 14.sp,
                color = Color(0xFF14100D),
                fontFamily = WorkSansFontFamily,
                fontWeight = FontWeight.Bold,
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
                Text(text = "Log in",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = WorkSansFontFamily,
                    fontWeight = FontWeight.Bold
                    )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onSignUpClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFF4E6))
            ) {
                Text(text = "Sign up",
                    color = Color(0xFFFF6F23),
                    fontSize = 16.sp,
                    fontFamily = WorkSansFontFamily,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun LoginDetailsScreen(onBackClick: () -> Unit, onSignUpClick: () -> Unit) {
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF14100D))
    ) {

        Image(
            painter = painterResource(id = R.drawable.orangecircle),
            contentDescription = "Circle",
            modifier = Modifier
                .size(264.dp)
                .align(Alignment.TopEnd)
                .offset(x = 60.dp, y = (-70).dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

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
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Welcome\nBack",
                color = Color(0xFFFFF4E6),
                fontSize = 32.sp,
                lineHeight = 34.sp,
                fontFamily = UnboundedFontFamily,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Log in to order dinner",
                color = Color(0xFFB9A89A),
                fontSize = 14.sp,
                fontFamily = WorkSansFontFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )


            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "EMAIL",
                color = Color(0xFFB9A89A),
                fontSize = 12.sp,
                fontFamily = WorkSansFontFamily,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = emailText,
                onValueChange = { emailText = it },
                placeholder = { Text("name@gmail.com",
                    color = Color(0xFF747473),
                    fontSize = 12.sp,
                    fontFamily = WorkSansFontFamily,
                    fontWeight = FontWeight.Medium
                    ) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF211A15),
                    unfocusedContainerColor = Color(0xFF211A15),
                    focusedBorderColor = Color(0xFFB9A89A),
                    unfocusedBorderColor = Color(0xFF382D25)
                )
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "PASSWORD",
                color = Color(0xFFB9A89A),
                fontSize = 12.sp,
                fontFamily = WorkSansFontFamily,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = passwordText,
                onValueChange = { passwordText = it },
                placeholder = { Text("* * * * * * * * ",
                    color = Color(0xFF747473),
                    fontSize = 12.sp,
                    fontFamily = WorkSansFontFamily,
                    fontWeight = FontWeight.Medium
                ) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF211A15),
                    unfocusedContainerColor = Color(0xFF211A15),
                    focusedBorderColor = Color(0xFFB9A89A),
                    unfocusedBorderColor = Color(0xFF382D25)
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.offset(x = (-12).dp)) {

                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFFF6A1F),
                            uncheckedColor = Color(0xFFFF6A1F),
                            checkmarkColor = Color(0xFF14100D)
                        )
                    )
                    Text(text = "Remember me",
                        fontSize = 10.sp,
                        color = Color(0xFFB9A89A),
                            fontFamily = WorkSansFontFamily,
                            fontWeight = FontWeight.Bold
                        )

                }
                TextButton(onClick = { }) {
                    Text(text = "Forgot password?",
                        fontSize = 10.sp,
                        color = Color(0xFFFF6A1F),
                            fontFamily = WorkSansFontFamily,
                            fontWeight = FontWeight.ExtraBold
                        )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6A1F))
            ) {
                Text(text = "Log in",
                    color = Color(0xFF14100D),
                    fontSize = 16.sp,
                    fontFamily = WorkSansFontFamily,
                    fontWeight = FontWeight.Bold
                    )
            }

            Spacer(modifier = Modifier.height(20.dp))

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
                    fontFamily = WorkSansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFB9A89A),
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFB43A)),
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

                    Text(text = "Log in with Google",
                        color = Color(0xFF14100D),
                        fontSize = 14.sp,
                        fontFamily = WorkSansFontFamily,
                        fontWeight = FontWeight.Medium
                    )

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

                    Text(text = "Log in with Apple",
                        color = Color(0xFF14100D),
                        fontSize = 14.sp,
                        fontFamily = WorkSansFontFamily,
                        fontWeight = FontWeight.Medium
                    )

                }

            }
            Spacer(modifier = Modifier.height(20.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Don't have an account? ",
                    color = Color(0xFFB9A89A),
                    fontSize = 12.sp,
                    fontFamily = WorkSansFontFamily,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Sign up.",
                    color = Color(0xFFFF7A00),
                    fontSize = 12.sp,
                    fontFamily = WorkSansFontFamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable {
                        onSignUpClick()

                    }
                )

            }
        }
    }
    }


        @Composable

        fun RegistrationScreen(onBackClick: () -> Unit) {
            var firstNameText by remember { mutableStateOf("") }
            var passwordText by remember { mutableStateOf("") }
            var emailText by remember { mutableStateOf("") }
            var phoneNumberText by remember { mutableStateOf("") }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF14100D))
            ) {

                Image(
                    painter = painterResource(id = R.drawable.yellowcircle),
                    contentDescription = "Circle",
                    modifier = Modifier
                        .size(210.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = (-280).dp, y = (-75).dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFDF7))
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(24.dp))

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

                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Let's get\nStarted",
                        color = Color(0xFFFFF4E6),
                        fontSize = 32.sp,
                        lineHeight = 34.sp,
                        fontFamily = UnboundedFontFamily,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Registration will take a minute",
                        color = Color(0xFFB9A89A),
                        fontSize = 14.sp,
                        fontFamily = WorkSansFontFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )


                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "FIRST NAME",
                        color = Color(0xFFB9A89A),
                        fontSize = 12.sp,
                        fontFamily = WorkSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    OutlinedTextField(
                        value = firstNameText,
                        onValueChange = { firstNameText = it },
                        placeholder = {
                            Text(
                                text = "First name",
                                color = Color(0xFF747473),
                                fontSize = 12.sp,
                                fontFamily = WorkSansFontFamily,
                                fontWeight = FontWeight.Medium,
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFF211A15),
                            unfocusedContainerColor = Color(0xFF211A15),
                            focusedBorderColor = Color(0xFFB9A89A),
                            unfocusedBorderColor = Color(0xFF382D25)
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "EMAIL",
                        color = Color(0xFFB9A89A),
                        fontSize = 12.sp,
                        fontFamily = WorkSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    OutlinedTextField(
                        value = emailText,
                        onValueChange = { emailText = it },
                        placeholder = {
                            Text(
                                text = "name@gmail.com",
                                color = Color(0xFF747473),
                                fontSize = 12.sp,
                                fontFamily = WorkSansFontFamily,
                                fontWeight = FontWeight.Medium,
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFF211A15),
                            unfocusedContainerColor = Color(0xFF211A15),
                            focusedBorderColor = Color(0xFFB9A89A),
                            unfocusedBorderColor = Color(0xFF382D25)
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "PHONE NUMBER",
                        color = Color(0xFFB9A89A),
                        fontSize = 12.sp,
                        fontFamily = WorkSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    OutlinedTextField(
                        value = phoneNumberText,
                        onValueChange = { phoneNumberText = it },
                        placeholder = {
                            Text(
                                text = "+380",
                                color = Color(0xFF747473),
                                fontSize = 12.sp,
                                fontFamily = WorkSansFontFamily,
                                fontWeight = FontWeight.Medium,
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFF211A15),
                            unfocusedContainerColor = Color(0xFF211A15),
                            focusedBorderColor = Color(0xFFB9A89A),
                            unfocusedBorderColor = Color(0xFF382D25)
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "PASSWORD",
                        color = Color(0xFFB9A89A),
                        fontSize = 12.sp,
                        fontFamily = WorkSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    OutlinedTextField(
                        value = passwordText,
                        onValueChange = { passwordText = it },
                        placeholder = {
                            Text(
                                text = "* * * * * * * *",
                                color = Color(0xFF747473),
                                fontSize = 12.sp,
                                fontFamily = WorkSansFontFamily,
                                fontWeight = FontWeight.Medium,
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFF211A15),
                            unfocusedContainerColor = Color(0xFF211A15),
                            focusedBorderColor = Color(0xFFB9A89A),
                            unfocusedBorderColor = Color(0xFF382D25)
                        )
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6A1F))
                    ) {

                        Text(text = "Sign up",
                            color = Color(0xFF14100D),
                            fontSize = 16.sp,
                            fontFamily = WorkSansFontFamily,
                            fontWeight = FontWeight.Bold,
                            )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "By continuing, you accept ",
                            color = Color(0xFFB9A89A),
                            fontSize = 12.sp,
                            fontFamily = WorkSansFontFamily,
                            fontWeight = FontWeight.Medium,
                        )
                        Text(
                            text = "the Terms of Service ",
                            color = Color(0xFFFF8A4C),
                            fontSize = 12.sp,
                            fontFamily = WorkSansFontFamily,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.clickable {}
                        )

                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "and ",
                            color = Color(0xFFB9A89A),
                            fontSize = 12.sp,
                            fontFamily = WorkSansFontFamily,
                            fontWeight = FontWeight.Medium,
                        )
                        Text(
                            text = "Privacy Policy.",
                            color = Color(0xFFFF8A4C),
                            fontSize = 12.sp,
                            fontFamily = WorkSansFontFamily,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.clickable {}
                        )
                    }


                }

            }
        }










