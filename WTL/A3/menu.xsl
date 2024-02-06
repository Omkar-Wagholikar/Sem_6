<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <head>
        <style>
          body {
            font-family: Arial, sans-serif;
          }
          h2 {
            color: #333;
          }
          table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
          }
          th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
          }
          th {
            background-color: #f2f2f2;
          }
        </style>
      </head>
      <body>
        <h2>Employees Information</h2>
        <xsl:apply-templates select="menu/category"/>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="category">
    <h3><xsl:value-of select="name"/></h3>
    <table>
      <tr>
        <th>Name</th>
        <th>Salary</th>
      </tr>
      <xsl:for-each select="item">
        <tr>
          <td><xsl:value-of select="name"/></td>
          <td><xsl:value-of select="price"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </xsl:template>

</xsl:stylesheet>
