package com.example.binconverter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.binconverter.ui.theme.BinConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BinConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BinConverterApp(
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun BinConverterApp(modifier: Modifier = Modifier) {
    val INPUT_MAX_SIZE = 10
    var textInputValue by remember {
        mutableStateOf("")
    }

    val decimalValue = binaryToDecimal(textInputValue.toLongOrNull() ?: 0)



    Column(
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.convert_to), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = decimalValue.toString(), fontSize = 56.sp)
        Spacer(modifier = Modifier.height(48.dp))
        OutlinedTextField(
            value = textInputValue,
            onValueChange = {
                textInputValue = parseInput(it, INPUT_MAX_SIZE)
            },
            singleLine = true,
            placeholder = {
                Text(text = "0")
            },
            supportingText = {
                Text(text = stringResource(R.string.input_suport_text))
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Clear, contentDescription = "clear")
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BinConverterAppPreview() {
    BinConverterTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            BinConverterApp(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}