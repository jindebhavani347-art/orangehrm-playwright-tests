package Page;

import com.microsoft.playwright.Page;

public class PageObjectManager {
    private final Page page;
    private addLeaveEntitlement addLeaveEntitlement;
    public leavepage leavepage;
    private LoginPage loginPage;
    private PIMPage pimPage;
    private Createcontactpage Createcontactpage;
    private Upadatepage Upadatepage;
    private ApplyLeave ApplyLeave;
    private systemuser systemuser;
    private EmpTimesheet EmpTimesheet;

    public PageObjectManager(Page page) {
        this.page = page;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) { loginPage = new LoginPage(page); }
        return loginPage;
    }

    public PIMPage getPIMPage() {
        if (pimPage == null) { pimPage = new PIMPage(page); }
        return pimPage;
    }

   public Createcontactpage getCreatepage() {
       if (Createcontactpage == null) {
            Createcontactpage = new Createcontactpage(page);
       }
       return Createcontactpage;
   }

   public Createcontactpage getCreatecontactpage() {
       if (Createcontactpage == null) {
           Createcontactpage = new Createcontactpage(page);
       }
     return   Createcontactpage;
   }
public Upadatepage getUpadatepage(){
        if(Upadatepage==null){
            Upadatepage=new Upadatepage(page);
        }
        return Upadatepage;
}


public  leavepage getLeavepage(){
  if(leavepage ==null){
      leavepage =new leavepage(page);
  }
    return leavepage;
}
    public  ApplyLeave getApplyLeave(){
        if(ApplyLeave ==null){
            ApplyLeave =new ApplyLeave(page);
        }
        return ApplyLeave;
    }


public addLeaveEntitlement getaddLeaveEntitlement(){
        if(addLeaveEntitlement==null){
            addLeaveEntitlement=new addLeaveEntitlement(page);
        }
        return addLeaveEntitlement;
}

public systemuser getsystemuser(){
 if(systemuser == null){
    systemuser=new systemuser(page);
}
  return systemuser;
}

public EmpTimesheet getEmpTimesheet(){

    if(EmpTimesheet == null){
        EmpTimesheet=new EmpTimesheet(page);
        }return  EmpTimesheet;
}



}