/*
 * Ext JS Library 2.2.1
 * Copyright(c) 2006-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.onReady(function(){

    Ext.QuickTips.init();

    // turn on validation errors beside the field globally
    Ext.form.Field.prototype.msgTarget = 'side';

    var bd = Ext.getBody();


    /*
     * ================  Form 3  =======================
     */
    bd.createChild({tag: 'h2', html: ''});


    var top = new Ext.form.FormPanel({
        labelAlign: 'top',
        frame:true,
        title: 'Kabootar Chat System v1.0 - Truly Desi!',
        bodyStyle:'padding:5px 5px 5px 5px',
        width: 1000,
        items: [{
            layout:'column',
            items:[{
                columnWidth:0.85,
                layout: 'form',
                items: [{
                    xtype:'textarea',
					height: 193,
                    fieldLabel: 'Chat Area',
                    name: 'chatArea',
                    anchor:'95%'
                },{
                    xtype:'textarea',
					height: 45,
                    fieldLabel: 'Message Area',
                    name: 'msgArea',
                    anchor:'95%'
                }] 
			},{
                columnWidth:0.15,
				baseCls: 'align-fields',
                layout: 'form',
                items: [{
                    xtype:'textarea',
					height: 193,
                    fieldLabel: 'Users Area',
                    name: 'userArea',
                    anchor:'95%'
                },{
                    xtype:'button',
					cls: 'align-buttons',
					height: 45,
                    text: 'Send',
                    name: 'sendButton',
                    anchor:'95%'
                }] 
			}]
        }]
    });

    top.render(document.body);


});