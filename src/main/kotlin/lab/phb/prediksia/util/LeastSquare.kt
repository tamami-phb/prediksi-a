package lab.phb.prediksia.util

import lab.phb.prediksia.model.Resume
import org.springframework.stereotype.Component

class LeastSquare {
    companion object {
        fun convertTglToInt(tgl: String): Int {
            val result = tgl.substring(0, 4) + tgl.substring(5,7) +
                    tgl.substring(8,10)
            return Integer.parseInt(result)
        }

        fun calculate(data: List<Resume>) {
            val a = calculateA(data)
            val b = calculateB(data)
        }

        fun calculateB(data: List<Resume>): Double {
            val x = generateX(data)
            return 0.0;
        }

        fun generateX(data: List<Resume>): List<Int> {
            if(data.size % 2 == 0) { // jumlah data genap
                return generateXEven(data.size)
            } else { // jumlah data ganjil
                return generateXOdd(data.size)
            }
            return mutableListOf<Int>()
        }

        fun generateXOdd(jmlData: Int): List<Int> {
            var start = (jmlData / 2).toInt() - jmlData + 1
            var result = mutableListOf<Int>()
            var i = 0
            while(i++ < jmlData) {
                result.add(start++)
            }
            return result
        }

        fun generateXEven(jmlData: Int): List<Int> {
            return mutableListOf<Int>()
        }

        fun calculateA(data: List<Resume>): Double {
            var nilai = 0.0;
            data.forEach {
                nilai += it.nilai
            }
            return nilai / data.size
        }
    }
}