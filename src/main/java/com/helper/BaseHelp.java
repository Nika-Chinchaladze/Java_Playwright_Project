package com.helper;

import com.microsoft.playwright.Page;

public class BaseHelp {
    public final Page page;

    public BaseHelp(Page page) {
        this.page = page;
    }
}
