package com.jct.renthabesha.ui.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.jct.renthabesha.R
import com.jct.renthabesha.ui.theme.focusedTextFieldStroke
import com.jct.renthabesha.ui.theme.focusedTextFieldText
import com.jct.renthabesha.ui.theme.unfocusedTextFieldStroke
import com.jct.renthabesha.ui.theme.unfocusedTextFieldText

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    textValue: String,
    label: String,
    placeholder: String
) {

    var isShowPassword by remember {
        mutableStateOf(false)
    }
    
    if (label != "Password"){
        isShowPassword = true 
    }

    var text by remember {
        mutableStateOf("")
    }

    val focusRequester = remember {
        FocusRequester()
    };

    Column{
        Text(
            modifier = Modifier.clickable {
                focusRequester.requestFocus()
            },
            text = label,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = modifier.focusRequester(focusRequester),
            value = text,
            onValueChange = {
                text = it
            },

            placeholder = {
                Text(text = placeholder)
            },

            colors = TextFieldDefaults.colors(
                focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
                focusedIndicatorColor = MaterialTheme.colorScheme.focusedTextFieldStroke,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.unfocusedTextFieldStroke
            ),

            shape = RoundedCornerShape(12.dp),

            trailingIcon = {
                if (label == "Password") {
                    Icon(
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .clickable { isShowPassword = !isShowPassword }
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.visibility_icon),
                        contentDescription = null,
                    );
                }else null
            },

            singleLine = true,

            visualTransformation = if (isShowPassword) VisualTransformation.None else PasswordVisualTransformation(),
        )
    }
}












