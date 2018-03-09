CREATE TABLE output_field_names (
    name            varchar(80)
);

CREATE TABLE shopfl_field_names (
    name            varchar(80)
);

CREATE TABLE mainshop_field_names (
    name            varchar(80)
);

select * from mainshop_field_names left outer join output_field_names on mainshop_field_names.name=output_field_names.name left outer join shopfl_field_names on output_field_names.name=shopfl_field_names.name;

select mainshop_field_names.name as mainshop_field_name,output_field_names.name as output_field_name,shopfl_field_names.name as shopfl_field_name from mainshop_field_names full outer join output_field_names on mainshop_field_names.name=output_field_names.name full outer join shopfl_field_names on  mainshop_field_names.name=output_field_names.name and output_field_names.name=shopfl_field_names.name;

select mainshop_field_names.name as mainshop_field_name,output_field_names.name as output_field_name,shopfl_field_names.name as shopfl_field_name from mainshop_field_names natural full outer join output_field_names natural full outer join shopfl_field_names;

select * from mainshop_field_names natural full outer join output_field_names natural full outer join shopfl_field_names;

 TO  '/Users/zlq/Projects/work/mtdp/zhouleqin-project-docs/20171113mainshop调用方返回字段统计/20171218/mainshop_output_shopfl_fields.txt';