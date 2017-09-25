package com.company;

public class Dashboard {
    public static final String HTML_TOP =
             "<html>\n" +
            "<table align=\"center\" border=\"1\">\n" +
            "<tr>\n" +
            "<th>VIN</th>" +
            "<th>Odometer (miles)</th>" +
            "<th>Consumption (gallons)</th>" +
            "<th>Last Oil Change</th>" +
            "<th>Engine Size (liters)</th>\n" +
            "</tr>\n";

    public static final String TABLE_ROW_HTML =
                    "<tr>\n" +
                    "<td align=\"center\">%vin%</td>" +
                    "<td align=\"center\">%odometer%</td>" +
                    "<td align=\"center\">%consumption%</td>" +
                    "<td align=\"center\">%lastoilchange%</td>" +
                    "<td align=\"center\">%enginesize% <td>" +
                    "</tr>\n";

    public static final String HTML_FOOTER = "</table>\n" +
            "</body>\n" +
            "</html>";







}
