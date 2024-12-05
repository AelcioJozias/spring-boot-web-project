'use client';

import React from 'react';
import {Space, Table} from 'antd';
import {DeleteOutlined, EditOutlined} from '@ant-design/icons';

const columns = [
    {
        title: 'Nome',
        dataIndex: 'nome',
        key: 'nome',
        render: (text: string) => <a>{text}</a>,
        sorter: (a: any, b: any) => a.nome.localeCompare(b.nome),
    },
    {
        title: 'CPF',
        dataIndex: 'cpf',
        key: 'cpf',
        sorter: (a: any, b: any) => a.nome.localeCompare(b.nome),
    },
    {
        title: 'Cidade',
        dataIndex: 'cidade',
        key: 'address',
        sorter: (a: any, b: any) => a.nome.localeCompare(b.nome),
    },
    {
        title: 'Ação',
        key: 'acao',
        render: (_: any, record: any) => (
            <Space size="large">
                <a title="Editar"><EditOutlined/></a>
                <a title="Excluir"><DeleteOutlined/></a>
            </Space>
        ),
    },
];

const data = [
    {
        key: '1',
        nome: 'John Brown',
        cpf: 10889136955,
        cidade: 'New York No. 1 Lake Park'
    },
    {
        key: '2',
        nome: 'Jane Smith',
        cpf: 20987654321,
        cidade: 'Los Angeles Central'
    },
    {
        key: '3',
        nome: 'Alice Johnson',
        cpf: 30345678910,
        cidade: 'Chicago Downtown'
    },
    {
        key: '4',
        nome: 'Bob Williams',
        cpf: 40567891234,
        cidade: 'San Francisco Bay Area'
    },
    {
        key: '5',
        nome: 'Charlie Davis',
        cpf: 50678912345,
        cidade: 'Miami Beach'
    },
    {
        key: '6',
        nome: 'David Miller',
        cpf: 60789123456,
        cidade: 'Houston Heights'
    },
    {
        key: '7',
        nome: 'Eva Wilson',
        cpf: 70891234567,
        cidade: 'Dallas Uptown'
    },
    {
        key: '8',
        nome: 'Frank Moore',
        cpf: 80912345678,
        cidade: 'Phoenix Westside'
    },
    {
        key: '9',
        nome: 'Grace Taylor',
        cpf: 91023456789,
        cidade: 'Austin Central'
    }
];

const App = () => <Table columns={columns} dataSource={data} pagination={{pageSize: 5}}/>;
export default App;