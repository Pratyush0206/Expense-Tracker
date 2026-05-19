package com.example.expensetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {

    var amount by remember{
        mutableStateOf("")
    }
    var expenses by remember{
        mutableStateOf(listOf<String>())
    }

    Column(
        modifier=modifier.fillMaxSize().padding(16.dp)
    ){
        Text(
            text = "Expense Tracker",
            fontSize=28.sp
        )
        Spacer(modifier=Modifier.height(20.dp))

        OutlinedTextField(
            value=amount,
            onValueChange = {
                amount=it
            },
            label={
                Text("Enter amount")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (amount.isNotEmpty()) {
                    expenses = expenses + "₹$amount"
                    amount = ""
                }
            }
        ){
            Text("Add expense")
        }
        Spacer(modifier = Modifier.height(20.dp))

        expenses.forEach {

            Text(
                text = it,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExpenseTrackerTheme {
        Greeting()
    }
}