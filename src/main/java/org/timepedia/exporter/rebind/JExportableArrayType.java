package org.timepedia.exporter.rebind;

import com.google.gwt.core.ext.typeinfo.JArrayType;

/**
 *
 */
public class JExportableArrayType implements JExportableType {

  public JExportableArrayType(ExportableTypeOracle exportableTypeOracle,
      JArrayType array) {
    this.exportableTypeOracle = exportableTypeOracle;
    this.array = array;
  }

  private ExportableTypeOracle exportableTypeOracle;

  private JArrayType array;

  public boolean needsExport() {
    return getComponentType().needsExport();
  }

  public String getQualifiedSourceName() {
    return array.getQualifiedSourceName();
  }

  public JExportableType getComponentType() {
    return exportableTypeOracle
        .findExportableType(array.getComponentType().getQualifiedSourceName());
  }
}
