/*
* generated by Xtext
*/
package de.itemis.xtext.typesystem.dsl.ui.outline;

import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

import de.itemis.xtext.typesystem.dsl.tsDsl.MetaclassSpec;

/**
 * customization of the default outline structure
 * 
 */
public class TsDslOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	protected boolean _isLeaf(MetaclassSpec sp) {
		return true;
	}

	
}
