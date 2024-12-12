package com.example.playgroundspace

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.playgroundspace.ui.theme.PaddingAll
import com.example.playgroundspace.ui.theme.PaddingTop
import com.example.playgroundspace.ui.theme.PlaygroundSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                content = { paddingValues ->
                    // comment for column
                    Column(modifier = Modifier.padding(paddingValues)) {
                        // comment for first text

                        SectionBasicTextField()

                        SectionAlertDialog()
                    }
                }
            )
        }
    }
}

@Composable
fun TestRevertCommit() {
    // comment for first text
    Text(
        text = "First Text"
    )
    // comment for second text
    Text(
        text = "Second Text"
    )
    // comment for third text
    Text(
        text = "Third Text"
    )
    // comment for fourth text
    Text(
        text = "Fourth Text"
    )
}

@Preview
@Composable
fun SectionBasicTextField() {
    var inputRedeemPoint by remember {
        mutableStateOf(TextFieldValue())
    }

    Column(modifier = Modifier.background(Color.White)) {
        Text(
            text = stringResource(R.string.title_basic_textfield),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(PaddingTop)
        )
        DetailOfBasicTextFieldView(
            inputRedeemPoint = inputRedeemPoint,
            supportText = "1 คะแนน = 0.1 บาท",
            onValueChange = {
                inputRedeemPoint = inputRedeemPoint.copy(
                    text = it,
                    selection = TextRange(it.length)
                )
            },
            onButtonClick = {
                Log.d("debug", "click button")
            },
            buttonText = "use All"
        )
    }
}

@Composable
fun DetailOfBasicTextFieldView(
    inputRedeemPoint: TextFieldValue,
    supportText: String,
    onValueChange: (String) -> Unit,
    onButtonClick: () -> Unit,
    buttonText: String
) {
    Spacer(
        modifier = Modifier.padding(
            top = 8.dp,
            start = 8.dp,
            end = 8.dp
        )
    )
    CustomTextFieldWithButton(
        inputRedeemPoint.text,
        onValueChange = { inputText ->
            onValueChange.invoke(inputText)
        },
        onButtonClick = {
            onButtonClick()
        },
        buttonText = buttonText,
        supportText = supportText
    )
}

@Composable
fun CustomTextFieldWithButton(
    value: String,
    supportText: String,
    onValueChange: (String) -> Unit,
    onButtonClick: () -> Unit,
    buttonText: String
) {

    val focusManager = LocalFocusManager.current
    val keyBoardManager = LocalSoftwareKeyboardController.current
    var isFocused by remember { mutableStateOf(false) }
    val animatedOffsetY by animateFloatAsState(targetValue = if (isFocused || value.isNotEmpty()) -2f else 35f)

    val heightOfBasicTextField = 56.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingAll)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(heightOfBasicTextField)
        ) {
            Text(
                text = stringResource(id = R.string.placeholder_input_point),
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier
                    .offset(y = animatedOffsetY.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .heightIn(heightOfBasicTextField),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // TextField with weight to occupy remaining space
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 8.dp)
                        .onFocusChanged {
                            isFocused = it.isFocused
                        },
                    textStyle = TextStyle.Default.copy(color = Color.Black),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.clearFocus()
                        keyBoardManager?.hide()
                    }),
                    maxLines = 1
                )

                Button(
                    onClick = onButtonClick,
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier.padding(2.dp),
                    border = BorderStroke(
                        1.dp,
                        color = colorResource(id = R.color.header_text_color)
                    ),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(
                        text = buttonText,
                        color = colorResource(id = R.color.header_text_color)
                    )
                }
            }
        }

        // Draw a line that spans only the TextField's width
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        ) {
            drawLine(
                color = Color.Gray,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                strokeWidth = 1.dp.toPx()
            )
        }

        // ratio
        Text(
            text = supportText,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp
            ),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview
@Composable
fun SectionAlertDialog() {
    var openAlertDialog by remember {
        mutableStateOf(false)
    }

// ALERT DIALOG
    Button(
        onClick = {
            openAlertDialog = true
        },
        modifier = Modifier.padding(PaddingTop)
    ) {
        Text(
            "Show AlertDialog"
        )
        when {
            openAlertDialog -> {
                AlertDialogView(
                    onDismissRequest = {
                        openAlertDialog = false
                    },
                    onConfirmEvent = {
                        openAlertDialog = false
                    },
                    dialogTitle = stringResource(R.string.alert_dialog_title),
                    dialogText = stringResource(R.string.alert_dialog_description),
                    icon = Icons.Default.Warning
                )
            }
        }
    }
}

@Composable
fun AlertDialogView(
    onDismissRequest: () -> Unit,
    onConfirmEvent: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector
) {

    AlertDialog(
        modifier = Modifier.fillMaxWidth(0.9f),
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(
                text = dialogText
            )
        },
        shape = RoundedCornerShape(10.dp),
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmEvent()
                }
            ) {
                Text("Logout")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Cancel")
            }
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false,
            decorFitsSystemWindows = true,
        )
    )
}
