/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rnabloom.bloom.hash;

import java.util.Arrays;
import static rnabloom.bloom.hash.NTHash.NTMC64;

/**
 *
 * @author kmnip
 */
public class CanonicalNTHashIterator extends NTHashIterator {
    protected final long[] frhval = new long[2];

    public CanonicalNTHashIterator(int k, int h) {
        super(k, h);
    }

    @Override
    public void next() {
        if (pos == start) {
            NTMC64(seq, k, h, ++pos, frhval, hVals);
        }
        else if (pos < max) {
            NTMC64(seq.charAt(pos), seq.charAt(pos+k), k, h, frhval, hVals);
            ++pos;
        }
        else {
            Arrays.fill(hVals, 0);
            hVals = null;
        }
    }
}
