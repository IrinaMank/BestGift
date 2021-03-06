package com.giffter.bestgift.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class TransactionUtils {
    companion object {

        fun getCurrentFragment(fragmentManager: FragmentManager): Fragment? {
            val topFragmentPosition = fragmentManager.backStackEntryCount - 1
            val entry = fragmentManager.getBackStackEntryAt(topFragmentPosition)
            return if (entry != null) fragmentManager.findFragmentByTag(entry.name) else null
        }

        fun addFragment(manager: FragmentManager, containerId: Int, fragment: Fragment) {
            manager.beginTransaction()
                    .add(fragment, containerId.toString())
                    .addToBackStack(fragment.javaClass.name)
                    .commit()
        }

        fun replaceFragment(manager: FragmentManager, containerId: Int, fragment: Fragment) {
            manager.beginTransaction()
                    .replace(containerId, fragment)
                    .addToBackStack(fragment.javaClass.name)
                    .commit()
        }

        fun isEmpty(fragmentManager: FragmentManager): Boolean {
            return fragmentManager.backStackEntryCount == 0
        }

    }
}