/*
 * Ext JS Library 2.2.1
 * Copyright(c) 2006-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
Ext.namespace('Ext.skins');

Ext.skins.current = [
        ['exotic', 'Exotic Blue'],
        ['jazzy', 'Jazzy Pink'],
        ['nature', 'Nature Green']
];

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

	var store = new Ext.data.SimpleStore({
    	fields: ['key', 'value'],
    	data : Ext.skins.current
	});
	
    /*
     * ================  Simple form  =======================
     */
    bd.createChild({tag: 'h2', html: ''});


    var simple = new Ext.form.FormPanel({
        labelWidth: 75, // label settings here cascade unless overridden
        url:'save-form',
        frame:true,
        title: 'Kabootar Chat System v1.0 - Truly Desi!',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'textfield',

        items: [{
                fieldLabel: 'Username',
                name: 'userName',
                maxLength: 15,
                allowBlank:false
            },{
                fieldLabel: 'Password',
                name: 'passWord',
                inputType: 'password'
            }, new Ext.form.ComboBox({
                store: store,
			    displayField:'value',
			    fieldLabel: 'Skin',
			    typeAhead: true,
			    mode: 'local',
			    triggerAction: 'all',
			    emptyText:'Select a skin...'
            }), {
                fieldLabel: '',
                name: 'userId',
                hidden: true,
                hideLabel:true
            }
        ],

        buttons: [{
            text: 'Login',
            id: 'loginButton'
        },{
            text: 'Cancel',
            id: 'cancelButton'
        }]
    });

    simple.render(document.body);
    
    
});