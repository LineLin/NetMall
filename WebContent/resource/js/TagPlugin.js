function TagPlugin(prefix){
	this.prefix = prefix;
	this.cur = 1;
	this.tagClass = prefix + "-tag ";
	this.footClass = prefix + "-foot ";
}
TagPlugin.prototype.patten = /\d+/;
TagPlugin.prototype.registHoverEven = function(){
	var plugin = this;
	var navList = document.getElementsByClassName(this.tagClass);
	for(var i=0; i<navList.length; i++){
		navList[i].onmouseover = function(){
			plugin.changTag(this);
		};
	}
};
TagPlugin.prototype.changTag = function(nextTag){
	var curFoot = document.getElementsByClassName(this.footClass + "index" + this.cur)[0];
	var curTag = document.getElementsByClassName(this.tagClass + "index" + this.cur)[0];
	var nextIndex = this.patten.exec(nextTag.getAttribute('class'))[0];
	var nextFoot = document.getElementsByClassName(this.footClass + "index" + nextIndex)[0];

	/* 为当前导航栏class属性添加cur标签，并且去掉旧导航栏class属性中的cur标签*/
	// curTag.setAttribute('class',this.tagClass + "index" + this.cur);
	// nextTag.setAttribute('class',this.tagClass + "index" + nextIndex 
		// + " cur");
	var newClass = curTag.getAttribute('class').replace('cur','').trim();
	curTag.setAttribute('class',newClass);
	newClass = nextTag.getAttribute('class') + " cur";
	nextTag.setAttribute('class',newClass);

	/* 为当前Foot[class]属性添加cur标签，并且去掉旧Foot[class]属性中的cur标签*/
	// curFoot.setAttribute('class',this.footClass + "index" + this.cur);
	// nextFoot.setAttribute('class',this.footClass + "index" + nextIndex 
	// 	+ " cur");
	newClass = curFoot.getAttribute('class').replace('cur','').trim();
	curFoot.setAttribute('class',newClass);

	newClass = nextFoot.getAttribute('class') + " cur";
	nextFoot.setAttribute('class',newClass);

	this.cur = nextIndex;
};
