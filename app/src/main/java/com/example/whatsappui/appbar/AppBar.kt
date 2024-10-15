package com.example.whatsappui.appbar

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.HomeScreen
import com.example.whatsappui.R
import com.example.whatsappui.ui.theme.Black
import com.example.whatsappui.ui.theme.BlackGray
import com.example.whatsappui.ui.theme.DarkThinGray
import com.example.whatsappui.ui.theme.Gray
import com.example.whatsappui.ui.theme.LightBlack
import com.example.whatsappui.ui.theme.LightGray
import com.example.whatsappui.ui.theme.ThinBlack
import com.example.whatsappui.ui.theme.ThinGray
import com.example.whatsappui.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){
     var inputText by remember { mutableStateOf("") }




        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(end = 10.dp)
                .background(
                    if (isSystemInDarkTheme()) {
                        Black
                    } else White
                ),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = stringResource(R.string.whatsapp_title),
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary
            )

            Spacer(modifier = Modifier.weight(1f))
            androidx.compose.material3.Icon(
                painter = painterResource(id = R.drawable.tabler_camera),
                contentDescription = "WhatsApp Camera", tint = if (isSystemInDarkTheme()) {
                    Color.White
                } else Color.Black
            )

            Spacer(modifier = Modifier.size(24.dp))
            androidx.compose.material3.Icon(
                painter = painterResource(id = R.drawable.qr_code_scanner_24),
                contentDescription = "QR Scanner", tint = if (isSystemInDarkTheme()) {
                    Color.White
                } else Color.Black
            )

            Spacer(modifier = Modifier.size(24.dp))
            androidx.compose.material3.Icon(
                painter = painterResource(id = R.drawable.baseline_more_vert_24),
                contentDescription = "menu", tint = if (isSystemInDarkTheme()) {
                    Color.White
                } else Color.Black
            )
        }

        OutlinedTextField(
            value = inputText, onValueChange = { inputText = it }, modifier = Modifier
                .fillMaxWidth().size(800.dp,50.dp)
                .padding(horizontal = 14.dp), shape = RoundedCornerShape(30.dp),
            leadingIcon = {
                androidx.compose.material3.Icon(
                    painter = painterResource(id = R.drawable.logos_meta_icon),
                    contentDescription = "META LOGO"
                )
            },
            placeholder = {
                Text(
                    text = "Ask Meta Ai or Search", fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal, color = if (isSystemInDarkTheme()) {
                        ThinGray
                    } else ThinBlack
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = if (isSystemInDarkTheme()) {
                    BlackGray
                } else ThinGray,
                focusedBorderColor = if (isSystemInDarkTheme()) {
                    ThinGray
                } else BlackGray,
                unfocusedBorderColor = if (isSystemInDarkTheme()) {
                    BlackGray
                } else ThinGray
            )
        )
    Spacer(modifier = Modifier.height(3.dp))
    Row {
        Button(onClick = { "" } ,
            modifier = Modifier.padding(start = 14.dp).size(70.dp,30.dp),
            colors =  ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = if (isSystemInDarkTheme()) {
                    LightGray
                } else LightBlack
            ) ) {
            Text(text = "All" , fontSize = 10.sp,)
        }
    }

}
@Preview
@Composable
fun AppBarPreview(){
    AppBar()
}
