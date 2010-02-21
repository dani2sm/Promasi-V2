package org.promasi.ui.promasiui.promasidesktop.programs.planner;


import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import org.promasi.shell.UiManager;
import org.promasi.ui.promasiui.promasidesktop.resources.ResourceManager;
import org.promasi.utilities.ui.ScreenUtils;


/**
 * 
 * A {@link JDialog} used to view the resources of a {@link GanttTaskSchedule}.
 * 
 * @author eddiefullmetal
 * 
 */
public class ViewResourcesDialog
        extends JDialog
{

    /**
     * {@link JTable} that contains all the resources of the
     * {@link #_taskToEdit} .
     */
    private JTable _resourcesTable;

    /**
     * The {@link GanttTaskSchedule} to view the resources from.
     */
    private GanttTaskSchedule _task;

    /**
     * Initializes the object.
     * 
     */
    public ViewResourcesDialog( GanttTaskSchedule task )
    {
        super( (Window) UiManager.getInstance( ).getRegisteredMainFrame( ) );
        setModal( true );
        setTitle( ResourceManager.getString( ViewResourcesDialog.class, "title" ) );
        setSize( ScreenUtils.sizeForPercentage( 0.4, 0.2 ) );
        ScreenUtils.centerInScreen( this );
        _task = task;
        initializeComponents( );
        initializeLayout( );
    }

    /**
     * Initializes the components.
     */
    private void initializeComponents ( )
    {
        _resourcesTable = new JTable( );
        _resourcesTable.setModel( new EmployeeTeamDataTableModel( _task.getResources( ) ) );
    }

    /**
     * Initializes the layout.
     */
    private void initializeLayout ( )
    {
        setLayout( new MigLayout( new LC( ).fill( ) ) );
        add( new JScrollPane( _resourcesTable ), new CC( ).grow( ) );
    }

}