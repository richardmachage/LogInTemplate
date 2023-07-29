package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.widget.ImageViewCompat
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        EditText( //Email Input
                            label = "Enter your Email",
                            hint = "Email",
                            iconLeading = Icons.Default.Email,
                            iconLeadingDescription = "Email Icon",
                            keyboardType = KeyboardType.Email
                        )

                        PasswordEditText( //PasswordInput
                            label = "Enter your Password",
                            hint = "Password",
                            iconLeading = Icons.Default.Lock,
                            iconLeadingDescription = "Password Icon",
                            keyboardType = KeyboardType.Password
                        )

                        TextButton( //Forgotten password button
                            modifier = Modifier
                                .padding(2.dp)
                                .align(Alignment.Start),
                            onClick = { /*TODO*/ }) {
                            Column() {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.Start),
                                    text = "Forgotten password?",
                                    fontStyle = FontStyle.Italic
                                )
                            }
                        }

                        Button( // Log In Button
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(
                                    start = (10.dp),
                                    end = (10.dp),
                                    top = (20.dp)
                                )
                                .fillMaxWidth()
                        ) {
                            Text(text = "Log In")
                        }

                        TextButton( // Sign Up Button
                            modifier = Modifier
                                .padding(5.dp)
                                .align(Alignment.Start),
                            onClick = { /*TODO*/ }) {
                            Column() {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.Start),
                                    text = "You don't have an account? Sing Up",
                                    fontStyle = FontStyle.Italic
                                )
                            }

                        }

                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(
    label: String,
    hint: String,
    iconLeading: ImageVector,
    iconLeadingDescription: String,
    keyboardType: KeyboardType
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = (10.dp), end = (10.dp)),
        value = text,
        label = { Text(label) },
        placeholder = { Text(hint) },
        onValueChange = { newText -> text = newText },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        leadingIcon = {
            Icon(
                imageVector = iconLeading,
                contentDescription = iconLeadingDescription
            )
        },
        trailingIcon = {
                       IconButton(onClick = { text = TextFieldValue("") }) {
                           Icon(imageVector = Icons.Filled.Clear, contentDescription = "clear_input")
                       }
        },
        singleLine = true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordEditText(
    label: String,
    hint: String,
    iconLeading: ImageVector,
    iconLeadingDescription: String,
    keyboardType: KeyboardType
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var showPassword by remember { mutableStateOf(value = false) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = (10.dp), end = (10.dp)),
        value = text,
        label = { Text(label) },
        placeholder = { Text(hint) },
        onValueChange = { newText -> text = newText },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        leadingIcon = {
            Icon(
                imageVector = iconLeading,
                contentDescription = iconLeadingDescription
            )
        },
        trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "hide_password"
                    )
                }
            } else {
                IconButton(onClick = { showPassword = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "show_password"
                    )
                }
            }
        },
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        singleLine = true

    )

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTheme {
        PasswordEditText( //PasswordInput
            label = "Enter your Password",
            hint = "Password",
            iconLeading = Icons.Default.Lock,
            iconLeadingDescription = "Password Icon",
            keyboardType = KeyboardType.Password
        )

    }
}
