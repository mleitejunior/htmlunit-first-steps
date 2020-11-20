package com.mleitejunior.htmlunittests;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Teste {
    private WebClient webClient;

    @Before
    public void init() throws Exception {
        webClient = new WebClient();
    }

    @After
    public void close() throws Exception {
        webClient.close();
    }

    @Test
    public void givenAClient_whenEnteringBaeldung_thenPageTitleIsOk()
            throws Exception {
        HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        Assert.assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());

        final String pageAsText = page.asText();
        Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
    }
}
