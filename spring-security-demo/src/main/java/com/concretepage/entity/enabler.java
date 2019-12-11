package com.concretepage.entity;

public enum enabler {
		enabled(1), disabled(2);
		
		private int isenabled;

		public int getIsenabled() {
			return isenabled;
		}
	
		private enabler(int isenabled) 
	    { 
	        this.isenabled = isenabled; 
	    } 
}
