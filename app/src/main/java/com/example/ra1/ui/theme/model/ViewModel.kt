package com.example.ra1.ui.theme.model


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class MainActivityModel :ViewModel() {
    //Angel Hernandez Trejo

    //variables para guardar nombre
    private val _nombre = mutableStateOf("")
    val nombre:State<String> = _nombre
    //variable para guardar la marca de auto
    private val _marca = mutableStateOf("")
    val marca:State<String> = _marca
    //variable para guardar el valor
    private val _valor = mutableStateOf(0.0)
    val valor:State<Double> = _valor
    //PROCESOS
    private val _financiamiento = mutableStateOf(0.0)
    val financiamiento:State<Double> = _financiamiento
    private val _anios = mutableStateOf(0)
    val anios:State<Int> = _anios
    private val _plazo = mutableStateOf("")
    val plazo:State<String> = _plazo
    private val _interes = mutableStateOf(0.0)
    val interes:State<Double> = _interes
    private val _tasa = mutableStateOf(0.0)
    private val _total = mutableStateOf(0.0)
    val total:State<Double> = _total
    private val _meses = mutableStateOf(0)
    private val _pagomensual = mutableStateOf(0.0)
    val pagomensual:State<Double> = _pagomensual
    //variale CONTIENE EL PRECIO DE LOS COCHES
    private val _Honda = mutableStateOf(678026.22)
    val HondaAccord:State<Double> = _Honda
    private val _Vw = mutableStateOf(879266.15)
    val VwTouareg:State<Double> = _Vw
    private val _BMW = mutableStateOf(1025366.87)
    val BMWX5:State<Double> = _BMW
    private val _Mazda = mutableStateOf(988641.02)
    val MazdaCX7:State<Double> = _Mazda
    private val _porcentaje = mutableStateOf(0)
    //variable para guardar el porcentaje
    val porcentaje:State<Int> = _porcentaje
    private val _enganche = mutableStateOf(0.0)
    val enganche:State<Double> = _enganche
    private val _Porcentage60 = mutableStateOf(60)
    val Porcetage60:State<Int> = _Porcentage60
    private val _Porcentage40= mutableStateOf(40)
    val Porcentage40:State<Int> = _Porcentage40
    private val _Porcentage20 = mutableStateOf(20)
    val Porcentage20:State<Int> = _Porcentage20



    //funcion de los autos
    fun autoHonda(){
        _marca.value = "Honda Accord $ ${ _Honda.value.toString() }"
        _valor.value = _Honda.value
    }
    fun autoVw(){
        _marca.value = "Vw Touareg $ ${_Vw.value.toString()}"
        _valor.value = _Vw.value
    }
    fun autoBMW(){
        _marca.value = "BMW X5 $ ${_BMW.value.toString()}"
        _valor.value = _BMW.value
    }
    fun autoMazda(){
        _marca.value = "Mazda CX7 $ ${ _Mazda.value.toString() }"
        _valor.value = _Mazda.value
    }
    //funcion de porcentaje
    fun por20(){
        _porcentaje.value = _Porcentage20.value
        calcularEnganche(_porcentaje.value,_valor.value)
    }
    fun por40(){
        _porcentaje.value = _Porcentage40.value
        calcularEnganche(_porcentaje.value,_valor.value)
    }
    fun por60(){
        _porcentaje.value = _Porcentage60.value
        calcularEnganche(_porcentaje.value,_valor.value)
    }

    fun calcularEnganche(porcentaje:Int,valor:Double){
        _enganche.value = porcentaje * valor / 100
        calcularFinanciamiento(_valor.value,_enganche.value)

    }
    fun Nombre1(nombre:String){
        _nombre.value = nombre
    }
    fun calcularFinanciamiento(valor: Double, enganche:Double){
        _financiamiento.value = valor - enganche

    }
    fun calcularInteres(tasa:Double,financiamiento:Double, anios:Int){
        _interes.value = tasa * financiamiento / 100 * anios
        calcularTotal()
    }
    fun calcularTotal(){
        _total.value = _financiamiento.value + _interes.value
        _pagomensual.value = _total.value / _meses.value
    }
    //funcion de 1 año
    fun Unanos(){
        _plazo.value = "1 año, tasa 7.5%"
        _anios.value = 1
        _tasa.value = 7.5
        _meses.value = 12
        calcularInteres(_tasa.value,_financiamiento.value,_anios.value)

    }
    //funcion de 2 año
    fun Dosanos(){
        _plazo.value = "2 años, tasa 9.5%"
        _anios.value = 2
        _tasa.value = 9.5
        _meses.value = 24
        calcularInteres(_tasa.value,_financiamiento.value,_anios.value)

    }
    //funcion de 3 año
    fun Tresanos(){
        _plazo.value = "3 años, tasa 10.3%"
        _anios.value = 3
        _tasa.value = 10.3
        _meses.value = 36
        calcularInteres(_tasa.value,_financiamiento.value,_anios.value)
    }
    //funcion de 4 año
    fun cuatroanos(){
        _plazo.value = "4 años, tasa 12.6%"
        _anios.value = 4
        _tasa.value = 12.6
        _meses.value = 48
        calcularInteres(_tasa.value,_financiamiento.value,_anios.value)
    }
    //funcion de 5 año
    fun cincoanos(){
        _plazo.value = "5 años, tasa 13.5%"
        _anios.value = 5
        _tasa.value = 13.5
        _meses.value = 60
        calcularInteres(_tasa.value,_financiamiento.value,_anios.value)
    }
    // funcion de marcas de autos
    fun autoMarca(index:Int){
        when (index) {
            0 -> autoHonda()
            1 -> autoVw()
            2 -> autoBMW()
            3 -> autoMazda()
            else -> {
                print("")
            }
        }
    }
    // funcion para sacar el porcetaje
    fun Porcentaje1(index:Int){
        when (index) {
            0 -> por20()
            1 -> por40()
            2 -> por60()
            else -> {
                print("")
            }
        }
    }
    //funcion para sacar los años de finaciamiento
    fun Financiamientos(index: Int){
        when (index) {
            0 -> Unanos()
            1 -> Dosanos()
            2 -> Tresanos()
            3 -> cuatroanos()
            4 -> cincoanos()

            else -> {
                print("")
            }
        }
    }

}
