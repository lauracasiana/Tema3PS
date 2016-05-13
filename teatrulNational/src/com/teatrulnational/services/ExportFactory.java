package com.teatrulnational.services;

import com.teatrulnational.database.Exporter;

public class ExportFactory {

	private Exporter exporter;

	public ExportFactory(Exporter exp) {
		this.exporter = exp;
	}

	public boolean doExport() {
		return exporter.export();
	}
}
