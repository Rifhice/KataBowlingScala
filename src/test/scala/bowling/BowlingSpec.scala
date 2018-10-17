package bowling

import org.scalatest.{FunSpec, Matchers}

class BowlingSpec extends FunSpec with Matchers {
    describe("A Stack") {

        it("Frame should be spare") {
            assert(Frame(1, 9, 0).isSpare)
            assert(Frame(5, 5, 0).isSpare)
        }

        it("Frame should be strike") {
            assert(Frame(10, 0, 0).isStrike)
        }

        it("All roll with 0 pin down give a score of 0") {
            val player = Player(List[Frame](
                Frame(0,0,0),
                Frame(0,0,0),
                Frame(0,0,0),
                Frame(0,0,0),
                Frame(0,0,0),
                Frame(0,0,0),
                Frame(0,0,0),
                Frame(0,0,0),
                Frame(0,0,0),
                Frame(0, 0, 0, true)
            ))
            assert(player.computeScore === 0)
        }

        it("All roll with strikes give 300.") {
            val player = Player(List[Frame](
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10, 10, 10, true)
            ))
            assert(player.computeScore === 300)
        }

        it("All roll with 1 pin down give 20") {
            val player = Player(List[Frame](
                Frame(1,1,0),
                Frame(1,1,0),
                Frame(1,1,0),
                Frame(1,1,0),
                Frame(1,1,0),
                Frame(1,1,0),
                Frame(1,1,0),
                Frame(1,1,0),
                Frame(1,1,0),
                Frame(1, 1, 0, true)
            ))
            assert(player.computeScore === 20)
        }

        it("Should be 253") {
            val player = Player(List[Frame](
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(10,0,0),
                Frame(3, 2, 0, true)
            ))
            assert(player.computeScore === 253)
        }

        it("Should be 89") {
            val player = Player(List[Frame](
                Frame(3,4,0),
                Frame(5,1,0),
                Frame(8,1,0),
                Frame(1,2,0),
                Frame(10,0,0),
                Frame(9,0,0),
                Frame(5,5,0),
                Frame(3,6,0),
                Frame(9,0,0),
                Frame(3, 2, 0, true)
            ))
            assert(player.computeScore === 89)
        }
  }
}
