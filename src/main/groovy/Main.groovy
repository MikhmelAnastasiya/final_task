import geb.Browser

System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anastasiya_Mikhmel\\Documents\\DQE Training\\final task\\project\\chromedriver.exe")

Browser.drive {

    dlab = { page DLab }
    jupyter = { page Jupyter }
    jupyterNotebook = { page JupyterNotebook }

    to DLab
    dlab.epamSSOButton.click()

    at Jupyter
    waitFor() { jupyter.folder.displayed }
    jupyter.folder.click()

    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get("https://projectby.trainings.dlabanalytics.com/amikhmel53/notebooks/final_task.ipynb")

    at JupyterNotebook

    jupyterNotebook.cellButton.click()
    jupyterNotebook.runAllActionItem.click()

    waitFor() { $("div.output_subarea.output_html.rendered_html.output_result").displayed }

}


