package com.Library.service;

import com.Library.Model.Library;

import duolayer.DuolayerLib;

public class Libservice {

		public String createLib(Library abc) {
			DuolayerLib aa=new DuolayerLib();
			return aa.insertLib(abc);
		}
		public String updatelibr(Library abc) {
			DuolayerLib aa=new DuolayerLib();
			return aa.updateLib(abc);
		}
		
	}


