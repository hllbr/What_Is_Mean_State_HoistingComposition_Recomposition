package com.hllbr.what_is_mean_state_hoisting_composition_recomposition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hllbr.what_is_mean_state_hoisting_composition_recomposition.ui.theme.What_Is_Mean_State_HoistingComposition_RecompositionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
@Composable
fun MainScreen(){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            SpecialText(string = "Halibr9")
            Spacer(modifier = Modifier.padding(10.dp))
            SpecialText(string = "Hikocak")
            Spacer(modifier = Modifier.padding(5.dp))
            SpecialTextField()

        }

    }

}
@Composable
fun SpecialText(string:String){
    Text(text = string,
    fontSize = 20.sp,
    fontStyle = FontStyle.Italic,
    fontFamily = FontFamily.SansSerif)
}
@Composable
fun SpecialTextField(){
    var myString = remember{ mutableStateOf("")}
    TextField(value = myString.value,onValueChange ={
        myString.value = it
    } )


}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()


}
/*
            Eğer biz bu noktada aynı specialTextField fonksiyonundan yararlanmaya çalışırsak
            görsel olarak oluşturulacak fakat Sürekli oalrak myString ifadesi oluşturulacak her oluşturulan textField için aynı değişkenin adını kullanmak veya State dediğimiz yapının içerisinde bir çok değişken olabilir.
            Burada bir değişken oluşturularak değer tutulduğu için bize bir noktada sıkıntı çıkarabilir
            örnek bir senaryoda firebase gidilmesi yada database'e veya SQLite a kaydedilmesi veya  kopyalanması gibi bir durum oluştuğunda
            bir diğer işlemde mi gönderilecek göndermek istemediğim verilerin aktarılması benim db mi yada SQLite veya Firebase'imi şişirebilir.
            Bu sebeple tanımlama işleminin bu alanda yapılması çok mantıklı olmuyor tanımlama işlemini Composable dışında yapmamız mantıklı bir hal alır.Temel Mantık ile birlikte doğru algoritmayı kurmuş oluyoruz.
            Birinci SpecialTextField Database kaydedilsin diğerleri kaydedilmesin isteiğinde bulunma seçeneğimiz doğuyor.
            Şuan içerideki değişkenlere ulaşamıyorum bu sebeple kontrol benim elimde değil.:/
            Elimdeki fonksiyon eğer db ile kullanılsaydı alınan yazıları kaydetmek gibi bir işlemi olacaktı.

            ---Burada devreye giren bir algoritmamız bulunuyor.
            Stateless Composables = State verileri olabildiğince COMPOSABLE yapılardan çıkarmamız lazım
            Bu çıkarma işlemini nasıl gerçekleştirebiliriz.
            biz illa mutableStateof() kullanmak zorundayım ama illa şuana kadar kullanıldığı şekliyle kullanmak zorunda dğeilim StateContent içerisinde tutmak gibi seçeneklerimde masada bulunuyor.
            Fonksiyonuma parametre olarak verebilirim.stateless seviyeye ulşamak için kullanabileceğim seçeneklerden biri budur.

             */