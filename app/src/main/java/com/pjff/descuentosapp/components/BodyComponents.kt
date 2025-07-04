package com.pjff.descuentosapp.components

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


//Vid 60 , spacing del heading que es vertical
@Composable
fun SpaceH(size: Dp = 5.dp) {
    Spacer(modifier = Modifier.height(size))
}

//Vid 59, para el ancho
@Composable
fun SpaceW(size: Dp = 5.dp) {
    Spacer(modifier = Modifier.width(size))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Vid 60
fun MainTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        //Teclado para solo numeros
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            //Para que que se expanda a lo largo de nuestra pantalla
            .fillMaxWidth()
            //Para que tenga un padding en las orillas.
            .padding(horizontal = 30.dp)
    )
}

@Composable
//Vid 62
fun MainButton(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick, colors = ButtonDefaults.outlinedButtonColors(
            contentColor = color,
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(text = text)
    }
}

//Vid 66, alerta
@Composable
fun Alert(
    title: String,
    message: String,
    confirmText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissClick,
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            Button(onClick = { onConfirmClick()}) {
                Text(text = confirmText)
            }
        }
    )
}






