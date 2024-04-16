class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            a()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun a() {
    var game = Game()
    var screen by remember { mutableStateOf(Screen.main) }
    Column(Modifier){
        Text(text = game.printGame())
        Row {
            Button(onClick = { screen = Screen.garage}) {
                Text(text = "Garage")
            }
            Button(onClick = { screen = Screen.shop }) {
                Text(text = "Shop")
            }
            Button(onClick = { screen = Screen.gate}) {
                Text(text = "Gate")
            }
        }
    }
}

enum class Screen{
    main,garage,shop,gate
}

class Game{
    var player = Player()
    var garage = Garage()
    var shop = Shop()
    var gate = Gate()

    fun isGameEnd()=player.day >= 100

    fun printGame():String{
        return if(!isGameEnd()){
            "День ${player.day}\n" +
                    "Минералы ${player.minerals}"
        }else{
            "Игра окончена"
        }
    }
}

class Player{
    var ticket = false
    var minerals = 100
    var day = 1
}

class Garage{
    var minScanner = false
    var enemyScanner = false
    var armor = 0
    var robots = arrayOfNulls<Robot>(3)
}

class Shop{
    var items = arrayOf(
        ShopItem("Сканнер минералов",250,"Добавляет информацию о количестве минералов на карту")
    )
}

class ShopItem(var name:String,var price:Int, var disc:String){}


class Gate{
    var places = arrayOfNulls<Place>(5)

    fun genNewPlace(){
        var random = (0..places.size)

    }
}

enum class PlaceType(var names:String, var minMinerals:Int, var maxMinerals:Int, var enemy:Int){
    street("Улица",5,20,10),
    bridge("Мост",10,40,20),
    park("Парк",15,60,30),
    cars("Стоянка",20,80,40),
    station("Станция",25,100,50)
}

class Place{
    var minerals = 0
    var enemy = 0

    fun getMineralCount():Int{
        return 0
    }

    fun isEnemyShow():Boolean{
        return true
    }
}

class Robot{
    var mineral = 0
    var skill = 50

    fun fight():Boolean{
        return true
    }
}
