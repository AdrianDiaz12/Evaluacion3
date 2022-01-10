package com.adriandiaz.evc3;

import androidx.fragment.app.Fragment;
public interface NavigationHost {
    void navigateTo(Fragment fragment, boolean addToBackstack);

}
