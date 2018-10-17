package bowling

import scala.util.Random

case class Player(listFrames: List[Frame]){
    def computeScore(): Int = {
        var score = 0
        for (i <- 0 to listFrames.length - 1){
            var current = listFrames(i)
            if(current.isLast){
                score = score + current.shot1
                if(current.shot1 == 10){
                    score = score + current.shot2 + current.shot3
                }
                score = score + current.shot2
                if(current.shot1 + current.shot2 == 10){
                    score = score + current.shot3
                }                
                if(current.shot3 != -1){
                    if(current.shot3 == 10){
                        score = score + current.shot3 + 10
                    }
                    else{
                        score = score + current.shot3
                    }
                }
            }
            else{
                if(current.isStrike){ 
                    if(i < listFrames.length - 1){
                        var nextFrame = listFrames(i + 1)
                        if(nextFrame.isStrike){
                            if(i < listFrames.length - 2){
                                var nextNextFrame = listFrames(i + 2)
                                score = score + current.shot1 + nextFrame.shot1 + nextNextFrame.shot1
                            }
                        }
                        else{
                            score = score + current.shot1 + nextFrame.shot1 + nextFrame.shot2
                        }
                    }
                }
                else if(current.isSpare){
                    var nextFrame = listFrames(i + 1)
                    score = score + current.shot1 + current.shot2 + nextFrame.shot1
                }
                else{
                    score = score + current.shot1 + current.shot2
                }
            }
        }
        score
    }
}