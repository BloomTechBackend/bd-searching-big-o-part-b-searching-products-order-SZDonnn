package com.searchingsortingbigopartb.prework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages a list of AmazonPackages.
 * Individual packages can be found by ASIN.
 */
public class AmazonOrderService {

    private List<AmazonPackage> packages;

    /**
     * Constructs an AmazonOrderService object.
     * @param packages - The List of packages in the order
     */
    public AmazonOrderService(List<AmazonPackage> packages) {
        this.packages = packages;
    }

    /**
     * Does a linear search for a package in the known list of packages
     * @param asin - The ASIN being searched for.
     * @return the Amazon Package with the target ASIN
     */
    public AmazonPackage findPackageLinear(String asin) throws PackageNotFoundException {
        // PARTICIPANTS - Implement a linear search for a package matching the requested ASIN
        AmazonPackage result = null;

        for (AmazonPackage amazonPackage : packages) {
            if (amazonPackage.getAsin().equalsIgnoreCase(asin)) {
                result = amazonPackage;
                break;
            }
        }

        if (result == null) {
            throw new PackageNotFoundException();
        }

        return result;
    }

    /**
     * Does a binary search for a package in the known list of packages
     * Note: You should assume that the package list is already sorted when this method is called.
     * @param asin - The ASIN being searched for.
     * @return the Amazon Package with the target ASIN
     */
    public AmazonPackage findPackageBinary(String asin) throws PackageNotFoundException {
        // PARTICIPANTS - Implement a binary search for a package matching the requested ASIN
        AmazonPackage amazonPackage = null;
        int left = 0;
        int right = packages.size()-1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int result = asin.compareTo(packages.get(middle).getAsin());
            if (result == 0) {
                amazonPackage = packages.get(middle);
            }
            if (result > 0) {
                left = middle + 1;
            } else {
                right = middle -1;
            }
        }

        if (amazonPackage == null) {
            throw new PackageNotFoundException();
        }

        return amazonPackage;
    }
}
