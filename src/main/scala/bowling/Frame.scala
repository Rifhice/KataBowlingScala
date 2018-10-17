package bowling

case class Frame(val shot1: Int = -1, val shot2: Int = -1, val shot3: Int = -1, val isLast: Boolean = false){

    def isSpare(): Boolean = {
        shot1 + shot2 == 10 && shot1 != 10
    }

    def isStrike(): Boolean = {
        shot1 == 10
    }

}