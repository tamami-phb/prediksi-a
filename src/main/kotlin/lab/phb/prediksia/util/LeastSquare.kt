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

        fun calculate(data: List<Resume>): Double {
            val a = calculateA(data)
            val b = calculateB(data)

            val nextX = getNextX(data.size)
            return a + (b * nextX)
        }

        fun getNextX(i: Int): Int {
            val daftarX = generateX(i)
            if(i % 2 == 0) { // jml data genap
                return daftarX[i-1] + 2
            } else {
                return daftarX[i-1] + 1
            }
        }

        fun calculateB(data: List<Resume>): Double {
            val x = generateX(data.size)
            val x2 = calculateX2(x)
            val xy = calculateXY(data, x)
            return xy / x2;
        }

        fun calculateXY(data: List<Resume>, x: List<Int>): Double {
            var result = 0.0
            var i=0
            x.forEach {
                result += ( it * data[i++].nilai )
            }
            return result
        }

        fun calculateX2(x: List<Int>): Double {
            var result = 0.0
            x.forEach {
                result += (it*it)
            }
            return result
        }

        fun generateX(jmlData: Int): List<Int> {
            if(jmlData % 2 == 0) { // jumlah data genap
                return generateXEven(jmlData)
            } else { // jumlah data ganjil
                return generateXOdd(jmlData)
            }
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
            var start = (jmlData - 1) - ((jmlData - 1) * 2)
            var result = mutableListOf<Int>()
            var i=0
            while(i++ < jmlData) {
                result.add(start)
                start += 2
            }
            return result
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