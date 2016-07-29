/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rnabloom.bloom;

/**
 *
 * @author kmnip
 */
abstract class AbstractCountingBloomFilter {
    abstract void increment(String key);
    abstract float getCount(String key);
    abstract float getFPR();
}
