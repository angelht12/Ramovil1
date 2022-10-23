package com.example.ra1.ui.theme.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.ra1.R
import com.example.ra1.ui.theme.Ra1Theme
import com.example.ra1.ui.theme.model.MainActivityModel


class MainActivity : ComponentActivity() {
    val objeto_wiew_Mode: MainActivityModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Angel Hernandez Trejo
        //RA
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxHeight()

                    .padding(5.dp), horizontalAlignment =Alignment.CenterHorizontally
            ){
                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Cyan)
                        ,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    logo()
                    Text(text = "Cotizador de autos nuevos", fontWeight = FontWeight.W800)
                }


                Divider()
                accion(objeto_wiew_Mode)
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    coche()
                    Text(text = "Marca", fontWeight = FontWeight.Bold)


                    spinnermarcas(objeto_wiew_Mode = objeto_wiew_Mode)
                }
                Row(

                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    enganche()
                    //auto()
                    Text(text = "Enganche", fontWeight = FontWeight.Bold)
                    spinerenganche(objeto_wiew_Mode = objeto_wiew_Mode)
                }
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    finaciemiento()
                    Text(text = "Financiamiento (anual):", fontWeight = FontWeight.Bold)
                    spinnerfinanciamiento(objeto_wiew_Mode = objeto_wiew_Mode)
                }

                contienetexto(objeto_wiew_Mode = objeto_wiew_Mode)




            }


        }
    }
    //imagen del logo
    @Composable
    fun logo(){
        Row(
            modifier= Modifier


        ) {
            Image(painterResource(id = R.drawable.angel12),"")

        }
    }
    @Composable
    fun imgusuario(){
        Row(
            modifier= Modifier


        ) {
            Image(painterResource(id = R.drawable.usuario),"")

        }
    }

    @Composable
    fun enganche(){
        Row(
            modifier= Modifier


        ) {
            Image(painterResource(id = R.drawable.descuento),"")

        }
    }
    @Composable
    fun coche(){
        Row(
            modifier= Modifier


        ) {
            Image(painterResource(id = R.drawable.vehiculo),"")

        }
    }
    @Composable
    fun finaciemiento(){
        Row(
            modifier= Modifier


                .background(Color.Green)



        ) {
            Image(painterResource(id = R.drawable.finanzas),"")

        }
    }

    @Composable
    fun contienetexto(objeto_wiew_Mode: MainActivityModel) {

        Card(
            Modifier.fillMaxWidth()

        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth()
                        ,
                ) {
                    Text(text = "Nombre: "+objeto_wiew_Mode.nombre.value.toString())

                }
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "${objeto_wiew_Mode.marca.value.toString()}")

                }

                Row(
                    Modifier.fillMaxWidth(),

                ) {
                    Text(text = "Enganche")
                    Text(
                        text = "(${objeto_wiew_Mode.porcentaje.value.toString()}%) de $ ${objeto_wiew_Mode.enganche.value.toString()}"
                    )

                }
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Monto a financiar:"+objeto_wiew_Mode.financiamiento.value.toString())



                }
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Financiamiento a "+ objeto_wiew_Mode.plazo.value)

                }

                Text(text = "Monto de intereses por ${objeto_wiew_Mode.anios.value.toString()} años: ")
                Text(text = "$ ${objeto_wiew_Mode.interes.value.toString()}")
                //SD
                Text(text = "Monto a financiar + intereses: ")
                Text(text = "$ ${objeto_wiew_Mode.financiamiento.value.toString()} + $ ${objeto_wiew_Mode.interes.value.toString()} = ${objeto_wiew_Mode.total.value.toString()}")

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Pagos mensuales por: ")
                    Text(
                        text = "$ ${objeto_wiew_Mode.pagomensual.value.toString()}"
                    )

                }

                Text(text = "Costo total ( Enganche + Financiamiento ): ")
                Text(text = "$ ${objeto_wiew_Mode.enganche.value.toString()} + $ ${objeto_wiew_Mode.total.value.toString()} = $ ${objeto_wiew_Mode.enganche.value + objeto_wiew_Mode.total.value}")

            }
        }
    }
    // es el text fil para el nombre
    @Composable
    fun accion(objeto_wiew_Mode: MainActivityModel) {
        var _nombre = remember {
            mutableStateOf("")
        }
        Column(
            Modifier.fillMaxWidth()
                ,
        ) {
            Row(
                Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                imgusuario()
                Text(text = "Nombre:", fontWeight = FontWeight.Bold)

                TextField(
                    value = _nombre.value, onValueChange = {
                        _nombre.value = it
                        objeto_wiew_Mode.Nombre1(_nombre.value)
                    },
                    Modifier
                        .background(color = Color.White)
                        .width(200.dp),
                    keyboardOptions = KeyboardOptions(KeyboardCapitalization.None, true, KeyboardType.Text),
                )
            }

        }

    }

    //spiner de marcas
    @Composable
    fun spinnermarcas(objeto_wiew_Mode: MainActivityModel) {
        var expanded by remember { mutableStateOf(false) }
        val labels = listOf(
            "Honda Accord $678,026.22",
            "Vw Touareg $879,266.15",
            "BMW X5 $1,025,366.87",
            "Mazda CX7 $988,641.02",
        )
        Box {
            Button(onClick = { expanded = !expanded }) {
                Text("Selecione")
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = true },
            ) {
                labels.forEach { label ->
                    DropdownMenuItem(onClick = {
                        objeto_wiew_Mode.autoMarca(labels.indexOf(label))
                        expanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
    }
    //spiner enganche
    @Composable
    fun spinerenganche(objeto_wiew_Mode: MainActivityModel) {
        var expanded by remember { mutableStateOf(false) }
        val labels = listOf(
            "20%",
            "40%",
            "60%",
        )
        Box {
            Button(onClick = { expanded = !expanded }) {
                Text("Enganche")
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = true },
            ) {
                labels.forEach { label ->
                    DropdownMenuItem(onClick = {
                        objeto_wiew_Mode.Porcentaje1(labels.indexOf(label))
                        expanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
    }
    //spiner de finacimiento
    @Composable
    fun spinnerfinanciamiento(objeto_wiew_Mode: MainActivityModel,
    ) {
        var expanded by remember { mutableStateOf(false) }
        val labels = listOf(
            "1 año al 7.5%",
            "2 años al 9.5%",
            "3 años al 10.3%",
            "4 años al 12.6%",
            "5 años al 13.5%",
        )
        Box {
            Button(onClick = { expanded = !expanded }) {
                Text("Ver")
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = true },
            ) {
                labels.forEach { label ->
                    DropdownMenuItem(onClick = {
                        objeto_wiew_Mode.Financiamientos(labels.indexOf(label))
                        expanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
    }
}

