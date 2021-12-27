import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import kotlin.random.Random

fun main() {
    var count: Int by mutableStateOf(0)

    val list: MutableList<MutableList<Char>> = mutableStateListOf(
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
        mutableStateListOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'),
    )

    var rowIndex: Int by mutableStateOf(0)
    var colIndex: Int by mutableStateOf(0)
    var count15: Int by mutableStateOf(0)

    while(count15 < 15) {
        rowIndex = Random.nextInt(10)
        colIndex = Random.nextInt(10)
        if (list[rowIndex + 1][colIndex + 1] == '0') {
            list[rowIndex + 1][colIndex + 1] = '*'
            count15++
        }
    }


    for(row in 0..11) {
        for (col in 0..11) {

                if (list[row  ][col] == '*') {
                    if(list[row - 1][col - 1] != '*')
                    list[row - 1][col - 1]++
                    if( list[row - 1][col] != '*')
                    list[row - 1][col]++
                    if(list[row - 1][col + 1] != '*')
                    list[row - 1][col + 1]++

                   if( list[row][col - 1] != '*')
                    list[row][col - 1]++
                    if( list[row][col + 1] != '*')
                    list[row][col + 1]++

                    if(list[row + 1][col - 1] != '*')
                    list[row + 1][col - 1]++
                    if( list[row + 1][col] != '*')
                    list[row + 1][col]++
                    if(list[row + 1][col + 1] !='*')
                    list[row + 1][col + 1]++
                }

        }
    }








    renderComposable(rootElementId = "root") {
        Table {
            for (row in 0..9) {
                Tr {
                    for (col in 0..9) {
                        Td({
                            style {
                                border(5.px, LineStyle.Solid, Color.midnightblue)
                                width(100.px)
                                height(100.px)
                                textAlign("center")
                                fontSize(100.px)

                                // backgroundColor(logic.ColorMatch(logic.list[i][j]))
                                property("vertical-align", "center")

                            }
                            onClick {  console.log(list[row +1][col+1].toString()) }

                        })
                        {
                            Text(list[row + 1][col + 1].toString() ?: "")
                            






                        }
                    }
                }
            }


        }
    }
}

