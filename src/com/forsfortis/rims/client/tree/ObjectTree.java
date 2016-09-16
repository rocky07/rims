package com.forsfortis.rims.client.tree;

import java.util.ArrayList;
import java.util.List;

import com.forsfortis.rims.client.util.dbservice.ServiceFactory;
import com.forsfortis.rims.shared.BaseDto;
import com.forsfortis.rims.shared.FolderDto;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.Store;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.data.shared.loader.ChildTreeStoreBinding;
import com.sencha.gxt.data.shared.loader.TreeLoader;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.StoreFilterField;
import com.sencha.gxt.widget.core.client.tree.Tree;

public class ObjectTree implements IsWidget {

	class KeyProvider implements ModelKeyProvider<BaseDto>{

		@Override
		public String getKey(BaseDto item) {
			return item instanceof FolderDto?"f-":"m-"+item.getId().toString();
		}
		
	}
	
	//TODO remove test data
/*	private FolderDto getRoot(){
		FolderDto rootFolder=new FolderDto(1, "Root");
		return rootFolder;
	}*/
	
	private ContentPanel panel=null;
	@Override
	public Widget asWidget() {
		if(panel==null){
						
			final TreeStore<BaseDto> store=new TreeStore<BaseDto>(new KeyProvider());
			StoreFilterField<BaseDto> filter=new StoreFilterField<BaseDto>(){

				@Override
				protected boolean doSelect(Store<BaseDto> store, BaseDto parent, BaseDto item, String filter) {
					if(item instanceof FolderDto){
					return false;
					}
					String name =item.getName();
					name=name.toLowerCase();
					if(name.equals(filter.toLowerCase())){
						return true;
					}
					return false;
				}
				
			};
			filter.bind(store);
			
		      final Tree<BaseDto, String> tree = new Tree<BaseDto, String>(store, new ValueProvider<BaseDto, String>() {
		          @Override
		          public String getValue(BaseDto object) {
		            return object.getName();
		          }

		          @Override
		          public void setValue(BaseDto object, String value) {
		          }

		          @Override
		          public String getPath() {
		            return "name";
		          }
		        });
		        //tree.getStyle().setLeafIcon(ExampleImages.INSTANCE.music());


				// TODO Auto-generated method stub
				List<BaseDto> data=new ArrayList<>();
				FolderDto f1=new FolderDto(101, "a");
				FolderDto f2=new FolderDto(102, "b");
				//f1.addChild(f2);
				List<BaseDto> children1=new ArrayList<>();
				children1.add(new BaseDto(1021,"child"));
				children1.add(new BaseDto(1011,"child1"));
				f1.setChildren(children1);;
				
				final BaseDto baseDto = new BaseDto(1022,"child2");
				/*data.add(f1);*/
				data.add(f2);
				data.add(f1);
				//data.add(new BaseDto(22, "22"));
				
				FolderDto root=new FolderDto(2020, "root");
				List<BaseDto> children=new ArrayList<>();
				children.add(f1);
				children.add(f2);
				root.setChildren(children);	
				//root.addChild(f2);
				
				for (BaseDto base : root.getChildren()) {
			        store.add(base);
			        if (base instanceof FolderDto) {
			          processFolder(store, (FolderDto) base);
			        }
			      }
			

/*			

			
			ServiceFactory.getinstance().getObjectManagementService().getObjectManagementTree(new AsyncCallback<List<BaseDto>>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(List<BaseDto> result) {
					// TODO Auto-generated method stub
					List<BaseDto> data=new ArrayList<>();
					FolderDto f1=new FolderDto(101, "a");
					FolderDto f2=new FolderDto(102, "b");
					//f1.addChild(f2);
					List<BaseDto> children1=new ArrayList<>();
					children1.add(new BaseDto(1021,"child"));
					children1.add(new BaseDto(1011,"child1"));
					f1.setChildren(children1);;
					
					final BaseDto baseDto = new BaseDto(1022,"child2");
					data.add(f1);
					data.add(f2);
					data.add(f1);
					//data.add(new BaseDto(22, "22"));
					
					FolderDto root=new FolderDto(2020, "root");
					List<BaseDto> children=new ArrayList<>();
					children.add(f1);
					children.add(f2);
					root.setChildren(children);	
					//root.addChild(f2);
					
					for (BaseDto base : root.getChildren()) {
				        store.add(base);
				        if (base instanceof FolderDto) {
				          processFolder(store, (FolderDto) base);
				        }
				      }
				}
			});
			*/
			
			
			ButtonBar buttonBar=new ButtonBar();
			
		      
//			buttonBar.add(filter);
			buttonBar.setLayoutData(new MarginData(5));
			
			VerticalLayoutContainer vlc=new VerticalLayoutContainer();
			vlc.add(buttonBar,new VerticalLayoutData(1,-1));
			vlc.add(tree,new VerticalLayoutData(1,1));
			panel=new ContentPanel();
			panel.setHeading("Object Tree");
			panel.add(vlc);
			
		}
		
		// TODO Auto-generated method stub
		return panel;
	}
	
	 private void processFolder(TreeStore<BaseDto> store, FolderDto folder) {
		    for (BaseDto child : folder.getChildren()) {
		      store.add(folder, child);
		      if (child instanceof FolderDto) {
		        processFolder(store, (FolderDto) child);
		      }
		    }
		  }
	 
	
}
