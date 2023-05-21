package com.example.crud_jetpack_compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(
    nombre: String,
    inscripcion: String,
    sangre: String,
    telefono: String,
    email: String,
    monto: String,
    funNombre: (String) -> Unit,
    funInscripcion: (String) -> Unit,
    funSangre: (String) -> Unit,
    funTelefono: (String) -> Unit,
    funEmail: (String) -> Unit,
    funMonto: (String) -> Unit,
    isEditando: Boolean,
    funIsEditando: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    listaUsuarios: MutableList<Usuario>,
    funResetCampos: () -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funNombre(it) },
        label = { Text(text = "Nombre") },
        enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = inscripcion,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funInscripcion(it) },
        label = { Text(text = "Inscripcion") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = sangre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funSangre(it) },
        label = { Text(text = "Sangre") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = telefono,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funTelefono(it) },
        label = { Text(text = "Telefono") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funEmail(it) },
        label = { Text(text = "Email") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = monto,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funMonto(it) },
        label = { Text(text = "Monto") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Button(modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
        onClick = {
            if (isEditando) {
                editarUsuario(nombre, inscripcion, sangre, telefono, email, monto, listaUsuarios)
                funTextButton("Agregar Usuario")
                funIsEditando()

            } else {
                agregarUsuario(nombre, inscripcion, sangre, telefono, email, monto, listaUsuarios)
            }
            funResetCampos()
        }
    ) {
        Text(
            color = Color.White,
            text = textButton
        )
    }
}