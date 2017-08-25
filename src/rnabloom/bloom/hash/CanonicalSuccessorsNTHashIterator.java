/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rnabloom.bloom.hash;

import static rnabloom.bloom.hash.NTHash.NTM64;
import static rnabloom.bloom.hash.NTHash.cpOff;
import static rnabloom.bloom.hash.NTHash.msTab;

/**
 *
 * @author Ka Ming Nip
 */
public class CanonicalSuccessorsNTHashIterator {
    protected int k;
    protected long tmpValF, tmpValR;
    public long fHashVal, rHashVal;
    protected int numHash;
    public long[] hVals;
    
    public CanonicalSuccessorsNTHashIterator(final int k, final int numHash) {
        this.k = k;
        this.numHash = numHash;
        this.hVals = new long[numHash];
    }
    
    public void start(final long fHashVal, final long rHashVal, final char charOut) {
        tmpValF = Long.rotateLeft(fHashVal, 1) ^ msTab[charOut][k%64];
        tmpValR = Long.rotateRight(rHashVal, 1) ^ msTab[charOut&cpOff][63];
    }
    
    public void next(final char charIn) {
        fHashVal = tmpValF ^ msTab[charIn][0];
        rHashVal = tmpValR ^ msTab[charIn&cpOff][(k-1)%64];
        
        NTM64(Math.min(fHashVal, rHashVal), hVals, k, numHash);
    }
}